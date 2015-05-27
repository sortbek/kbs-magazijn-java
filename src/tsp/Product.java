package tsp;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;


public class Product {
	
	private List<Integer> inputList;
	private Rectangle cell;
	private Integer inter;
	private Warehouse ware;
	
	public Product(Integer inter,Rectangle cell, Warehouse ware){
		
			this.ware = ware;
			
			this.cell = cell;
			this.inter = inter;

			inputList = new ArrayList<Integer>();
			 
			inputList.add(inter);
			
			 
		 }
	
	public Rectangle getCell() {
		return cell;
	}

	public void setCell(Rectangle cell) {
		this.cell = cell;
	}

	
	public List<Integer> getInputList() {
		return inputList;
	}

	public void setInputList(List<Integer> inputList) {
		this.inputList = inputList;
	}

}

	

