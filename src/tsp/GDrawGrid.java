package tsp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

public class GDrawGrid extends JPanel {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private int columnCount;
	private int rowCount;
	private List<Rectangle> cells;
	private Point hoveredCell;
	private Point clickedCell;
	private Point initialCell;
	private double column;
	private double row;
	private CustomRowColumnLabel customRowColumnLabel;
	private ProductInfoLabel productInfoLabel;
	private Warehouse ware;
	private CustomRowColumnLabel label;
	private double width;
	private double height;
	private Algorithm algorithm;
	private ArrayList<Point> circels;

	// /////////// INIT GRID && REDRAW /////////////

	public GDrawGrid(int columnCount, int rowCount,
			CustomRowColumnLabel customRowColumnLabel,
			ProductInfoLabel productInfoLabel) {

		this.columnCount = columnCount;
		this.rowCount = rowCount;

		width = 526;
		height = 528;

		ware = new Warehouse(rowCount, columnCount, width, height);
		cells = ware.getShelf().getCells();

		this.customRowColumnLabel = customRowColumnLabel;
		this.productInfoLabel = productInfoLabel;
		addMouse();

		calculatePath(0);

	}

	public void reDraw(int columnCount, int rowCount, int spinner) {
		this.columnCount = columnCount;
		this.rowCount = rowCount;

		width = getWidth();
		height = getHeight();
		ware = new Warehouse(rowCount, columnCount, width, height);
		cells = ware.getShelf().getCells();

		repaint();

		calculatePath(spinner);
	}

	// /////////// BEGIN PAINT /////////////

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();

		// Height & Width of panel

		double width = getWidth();
		double height = getHeight();

		// Heigth & Width of every cell

		double cellWidth = width / columnCount;
		double cellHeight = height / rowCount;

		// Begin of offset X & Y

		double xOffset = (width - (columnCount * cellWidth)) / 2;
		double yOffset = (height - (rowCount * cellHeight)) / 2;

		if (cells.isEmpty()) {
			for (int row = 0; row < rowCount; row++) {
				for (int col = 0; col < columnCount; col++) {
					Rectangle cell = new Rectangle(
							(int) (xOffset + (col * cellWidth)),
							(int) (yOffset + (row * cellHeight)),
							(int) cellWidth, (int) cellHeight);
					cells.add(cell);
				}
			}
		}

		if (hoveredCell != null) {

			int index = hoveredCell.x + (hoveredCell.y * columnCount);
			try {
				Rectangle cell = cells.get(index);
				g2d.setColor(Color.BLUE);
				g2d.fill(cell);
			} catch (IndexOutOfBoundsException ex) {
			}

		}

		if (clickedCell != null) {
			int index = clickedCell.x + (clickedCell.y * columnCount);

			try {

				Rectangle cellPut = new Rectangle();
				cellPut = cells.get(index);

				g2d.setColor(Color.red);
				g2d.fill(cellPut);

			} catch (IndexOutOfBoundsException ex) {

			}

		}

		g2d.setColor(Color.GRAY);
		int count = 1;

		for (Rectangle cell : cells) {
			g2d.draw(cell);

			double rectWdth = cell.getWidth();
			double rectHgt = cell.getHeight();

			double sizeCount = rectHgt * 0.18;
			int fontSize = (int) sizeCount;

			Font font = new Font("Tahoma", Font.PLAIN, fontSize);
			g2d.setFont(font);

			FontMetrics metrics = g2d.getFontMetrics(font);

			int hgt = metrics.getHeight();

			// int wdth = metrics.stringWidth(Integer.toString(count));

			double padding = rectWdth * 0.05;
			double minX = cell.getMinX();
			double minY = cell.getMinY();
			g2d.setStroke(new BasicStroke(2));
			g2d.drawString(Integer.toString(count), (int) (minX + padding),
					(int) (minY + hgt));

			double widthCell = cell.getWidth();
			double heightCell = cell.getHeight();

			int x1 = -1;
			int y1 = -1;

			int x2 = -1;
			int y2 = -1;

			for (Point circel : circels) {

				if (x1 == -1) {
					x1 = circel.x;
					y1 = circel.y;
				} else {

					x2 = circel.x;
					y2 = circel.y;

					g2d.drawLine(x1, y1, x2, y2);

					x1 = circel.x;
					y1 = circel.y;

				}

				int radius1 = (int) ((heightCell / 2) * 0.5);
				int radius2 = (int) ((widthCell / 2) * 0.5);

				int diameter1 = radius1 * 2;
				int diameter2 = radius2 * 2;

				g2d.fillOval(circel.x - radius2, circel.y - radius1, diameter2,
						diameter1);

			}

			count++;

		}

		g2d.dispose();
	}

	// /////////// DRAW METHODS /////////////

	public void drawLeftAboveString(String s, int w, int h, Graphics g) {
		FontMetrics fm = g.getFontMetrics();
		int x = (w - fm.stringWidth(s));
		int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())));
		g.drawString(s, x, y);
	}

	// /////////// POINT METHODS /////////////

	// /////////// MOUSE CONFIG /////////////

	public void addMouse() {
		MouseAdapter mouseHandler;
		mouseHandler = new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent evt) {

				locationFind(evt);

				// +1 omdat we bij 1 willen beginnen en niet 0;

				customRowColumnLabel.setTextRC((int) (column + 1),
						(int) (row + 1));

				clickedCell = new Point((int) column, (int) row);

				int index = clickedCell.x + (clickedCell.y * columnCount);
				Rectangle cellPut = new Rectangle();
				cellPut = cells.get(index);

				String input = "" + ware.getCache().get(cellPut);
				productInfoLabel.setTextLabel(input);
				// System.out.println("Center x: "+cellPut.getCenterX()+" Center Y: "+cellPut.getCenterY()+" index : "+(index+1));

				repaint();
			}

			public void mouseMoved(MouseEvent e) {
				locationFind(e);

				hoveredCell = new Point((int) column, (int) row);
				repaint();

			}

		};

		addMouseMotionListener(mouseHandler);
		addMouseListener(mouseHandler);
	}

	public void locationFind(MouseEvent e) {
		double width = ware.getWidth();
		double height = ware.getHeight();

		double cellWidth = width / ware.getColumns();
		double cellHeight = height / ware.getRows();

		column = e.getX() / cellWidth;
		row = e.getY() / cellHeight;

	}

	// /////////// INVALIDATION /////////////

	@Override
	public void invalidate() {
		// dodelijk
		// cells.clear();
		hoveredCell = null;
		clickedCell = null;
		super.invalidate();

	}

	// /////////// POINT FINDERS /////////////

	public Point findInitialPoint(double width, double height,
			List<Rectangle> cells) {
		Point pointCheck = new Point();
		pointCheck.setLocation(5, (height - 5));

		initialCell = new Point();

		for (Rectangle cell : cells) {

			if (cell.contains(pointCheck)) {
				initialCell.setLocation(cell.getCenterX(), cell.getCenterY());
			}
		}

		return initialCell;
	}

	// /////////// INIT && FIND PATH /////////////

	public void calculatePath(int spinner){
		
		double size  = cells.size();
		int forLoop = (int)(Math.round(size/10));
		
		
		if(spinner == 0){
			algorithm = Algorithm.Enumeratie;
		}else if(spinner == 1){
			algorithm = Algorithm.Neighbour;
		}else{
			algorithm = Algorithm.HeldKarp;
		}
		
		
		algorithm = Algorithm.Enumeratie;

		ArrayList<Point> coordinates;
		
		coordinates = new ArrayList<Point>();
		
		int countOfRuns = 7;

		for(int i = 0; i < countOfRuns; i++){
			
			Random rand = new Random();

			int  n = rand.nextInt(((int)size));
			
			Rectangle cell;
			try{
				cell = cells.get(n);
			}catch(IndexOutOfBoundsException io){
				cell = cells.get(n-1);
			}
			
			
			double x = cell.getCenterX();
			double y = cell.getCenterY();
			
			Point e = new Point();
			e.setLocation(x, y);
			
			coordinates.add(e);
			
			
		}
		
		
		circels = algorithm.calculatePath(coordinates, findInitialPoint(this.width, this.height, cells));

			
		//System.out.println(algorithm.toString());
	}

	// /////////// GETTERS && SETTERS /////////////

	public CustomRowColumnLabel getLabel() {
		return label;

	}

	public void setLabel(CustomRowColumnLabel label) {
		this.label = label;
	}

	public Warehouse getWare() {
		return ware;
	}

	public void setWare(Warehouse ware) {
		this.ware = ware;
	}

	public Algorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

}
