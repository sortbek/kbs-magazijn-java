package tsp;


import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.List;

public class Warehouse {
	
	private int rows; 
	private Warehouse ware;
	private int columns;
	private double width;
	private double height;
	private HashMap<Rectangle, List<String>> cache;
	private Shelf shelf;
	/*private List<String> inputList;*/
	
	public Warehouse(int rows, int columns, double width, double height){
		
		this.rows = rows;
		this.columns = columns;
		this.ware = this;
		this.width = width;
		this.height = height;
		
	
		
		//initializing ArrayList && Hashmap
		
		cache = new HashMap<Rectangle, List<String>>();
		
		
		//Calculating & creating shelfs
		
		shelf = new Shelf(ware);
		
				
	}

	
	public int getRows() {
		return rows;
	}


	public void setRows(int rows) {
		this.rows = rows;
	}


	public int getColumns() {
		return columns;
	}


	public void setColumns(int columns) {
		this.columns = columns;
	}


	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public HashMap<Rectangle, List<String>> getCache() {
		return cache;
	}


	public void setCache(HashMap<Rectangle, List<String>> cache) {
		this.cache = cache;
	}


	public Shelf getShelf() {
		return shelf;
	}


	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}


	@Override
	public String toString() {
		String toReturn = "";
		int i = 1;
		for (Rectangle cell : shelf.getCells()) {
		 	 
			 List<String> value = cache.get(cell);
			 toReturn = toReturn + i +" Key: " + cell +" value: "+ value+"\n";
			 i++;
			 
		 }
		return toReturn;
	}
	
	
	
	
		public String getValue(Rectangle cellPut){
		String toReturn = "";
		
		for (Rectangle cell: shelf.getCells()) {
		
			if(cell.equals(cellPut)){
				
				 List<String> value = cache.get(cell);
				
				 toReturn = toReturn + 1 +" Key: " + cell +" value: "+ value+"\n";
			}
	
			 
		 }
		return toReturn;
	}



	

}
