package tsp;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


public class GDrawGrid extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int columnCount;
	private int rowCount;
	private List<Rectangle> cells;
	private Point hoveredCell;
	private Point clickedCell;
	private double column;
	private double row;
	private CustomRowColumnLabel customRowColumnLabel;
	private ProductInfoLabel productInfoLabel;
	
	

	public void reDraw(int columnCount, int rowCount) {
		this.columnCount = columnCount;
		this.rowCount = rowCount;
		cells = new ArrayList<>(columnCount * rowCount);
		mouseFix();
		repaint();


	}

	public GDrawGrid(int columnCount, int rowCount, CustomRowColumnLabel customRowColumnLabel, ProductInfoLabel productInfoLabel) {
		this.columnCount = columnCount;
		this.rowCount = rowCount;
		this.customRowColumnLabel = customRowColumnLabel;
		this.productInfoLabel = productInfoLabel;
		cells = new ArrayList<>(columnCount * rowCount);
		mouseFix();
	}

	public void mouseFix() {
		MouseAdapter mouseHandler;
		mouseHandler = new MouseAdapter() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				locationFind(e);
				

				hoveredCell = new Point((int) column, (int) row);
				repaint();

			}
			public void mousePressed(MouseEvent e) {
				
				
				locationFind(e);
				CustomRowColumnLabel label = new CustomRowColumnLabel();
				
				customRowColumnLabel.setTextRC((int) (column+1), (int) (row+1));
				productInfoLabel.setTextProductInfo();
			    clickedCell = new Point((int) column, (int) row);
			    
			    }
			
		};
		addMouseMotionListener(mouseHandler);
		addMouseListener(mouseHandler);
	}

	@Override
	public void invalidate() {
		cells.clear();
		hoveredCell = null;
		super.invalidate();
	}

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
		
		if (clickedCell !=null){
			int index = clickedCell.x + (clickedCell.y * columnCount);
			
			try {
				Rectangle cell = cells.get(index);
				g2d.setColor(Color.red);
				g2d.fill(cell);
			} catch (IndexOutOfBoundsException ex) {
				
			}
			
		}

		g2d.setColor(Color.GRAY);
		int count = 1;

		for (Rectangle cell : cells) {
			g2d.draw(cell);
			
			if (cells.size() > 1999) {
				g2d.setFont(g2d.getFont().deriveFont(1.0f));
			} else if (cells.size() > 1499) {
				g2d.setFont(g2d.getFont().deriveFont(2.0f));
			} else if (cells.size() > 999) {
				g2d.setFont(g2d.getFont().deriveFont(4.0f));
			} else if (cells.size() > 624) {
				g2d.setFont(g2d.getFont().deriveFont(6.0f));
			} else if (cells.size() > 225) {
				g2d.setFont(g2d.getFont().deriveFont(8.0f));
			} else if (cells.size() > 100) {
				g2d.setFont(g2d.getFont().deriveFont(10.0f));
			} else if (cells.size() > 25) {
				g2d.setFont(g2d.getFont().deriveFont(20.0f));
			}else if (cells.size() >= 1){
				g2d.setFont(g2d.getFont().deriveFont(30.0f));
			}
			
 
			
			drawLeftAboveString(Integer.toString(count), (int)cell.getCenterX(), (int)cell.getCenterY(), g2d);

			count++;
		}

		g2d.dispose();
	}
	
	  public void drawLeftAboveString(String s, int w, int h, Graphics g) {
		    FontMetrics fm = g.getFontMetrics();
		    int x = (w - fm.stringWidth(s));
		    int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) );
		    g.drawString(s, x, y);
		  }
	  
	  public void locationFind(MouseEvent e){
		  double width = getWidth();
			double height = getHeight();

			double cellWidth = width / columnCount;
			double cellHeight = height / rowCount;

			column = e.getX() / cellWidth;
			row = e.getY() / cellHeight;
	  }
}
