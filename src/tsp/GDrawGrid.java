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
import java.util.HashMap;
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
	private Warehouse ware;
	private CustomRowColumnLabel label;
	
	

	public void reDraw(int columnCount, int rowCount) {
		this.columnCount = columnCount;
		this.rowCount = rowCount;
		
		
		
		double width = getWidth();
		double height = getHeight();
		
		ware = new Warehouse(rowCount, columnCount, width, height);
		cells = ware.getShelf().getCells();
		
		System.out.println(ware.toString());
	
		repaint();


	}

	public GDrawGrid(int columnCount, int rowCount, CustomRowColumnLabel customRowColumnLabel, ProductInfoLabel productInfoLabel) {
		
		this.columnCount = columnCount;
		this.rowCount = rowCount;

		ware = new Warehouse(rowCount, columnCount, 526, 520);
		cells = ware.getShelf().getCells();
		
		this.customRowColumnLabel = customRowColumnLabel;
		this.productInfoLabel = productInfoLabel;
		
		System.out.println(ware.toString());
		addMouse();
		repaint();
	}


	public void addMouse() {
		MouseAdapter mouseHandler;
		mouseHandler = new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent evt) { 
				
				locationFind(evt);
				setLabel(new CustomRowColumnLabel());
				
				//+1 omdat we bij 1 willen beginnen en niet 0;
				customRowColumnLabel.setTextRC((int) (column+1), (int) (row+1));
				
			    clickedCell = new Point((int) column, (int) row);

			    
			    int index = clickedCell.x + (clickedCell.y * columnCount);
				Rectangle cellPut = new Rectangle();
				cellPut = cells.get(index);
				
				
				
				String input = ""+ware.getCache().get(cellPut);
				System.out.println(input);
				productInfoLabel.setTextLabel(input);
			  
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

	@Override
	public void invalidate() {
		cells.clear();
		hoveredCell = null;
		clickedCell = null;
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
		
		if (clickedCell != null){
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
		  double width = ware.getWidth();
			double height = ware.getHeight();

			double cellWidth = width / ware.getColumns();
			double cellHeight = height / ware.getRows();

			column = e.getX() / cellWidth;
			row = e.getY() / cellHeight;
	  }

	public CustomRowColumnLabel getLabel() {
		return label;
	}

	public void setLabel(CustomRowColumnLabel label) {
		this.label = label;
	}
}
