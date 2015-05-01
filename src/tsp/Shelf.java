package tsp;


import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Shelf {
	

		private int rows; 
		private int columns;
		private double width;
		private double height;
		private Warehouse ware;
		private List<Rectangle> cells;
		Product product;
		
	public Shelf(Warehouse ware) {
				
		
		this.setWare(ware);
		this.rows = ware.getRows();
		this.columns = ware.getColumns();
		this.width = ware.getWidth();
		this.height = ware.getHeight();
		
		int j = 1;
		String input = "";
		String input2 = "a";
		
		cells = new ArrayList<Rectangle>(rows*columns);
		
		double cellWidth = width / columns;
		double cellHeight = height / rows;
		
		double xOffset = (width - (columns * cellWidth)) / 2;
		double yOffset = (height - (rows * cellHeight)) / 2;
		
		if (cells.isEmpty()) {
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < columns; col++) {
					Rectangle cell = new Rectangle(
							(int) (xOffset + (col * cellWidth)),
							(int) (yOffset + (row * cellHeight)),
							(int) cellWidth, (int) cellHeight);
					cells.add(cell);
				}
			}
		}
		
		for(Rectangle cell : cells){
			input = ""+j;
			input2 = "a"+j;
			
			product = new Product(input, input2, cell, ware);
			j++;
			
			ware.getCache().put(cell, product.getInputList());
			
		}
		
		
	}



	public List<Rectangle> getCells() {
		return cells;
	}

	public void setCells(List<Rectangle> cells) {
		this.cells = cells;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Warehouse getWare() {
		return ware;
	}

	public void setWare(Warehouse ware) {
		this.ware = ware;
	}



	
}
