package tsp;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;


public class Product {
	
	private List<String> inputList;
	private Rectangle cell;
	private String input;
	private String input2;
	private Warehouse ware;
	
	public Product(String input, String input2,Rectangle cell, Warehouse ware){
		
			this.ware = ware;
			this.cell = cell;
			this.input = input;
			this.input2 = input2; 
					 
			inputList = new ArrayList<String>();
			 
			inputList.add(input);
			inputList.add(input2);
			System.out.println(inputList);
			 
		 }
	
	public Rectangle getCell() {
		return cell;
	}

	public void setCell(Rectangle cell) {
		this.cell = cell;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getInput2() {
		return input2;
	}

	public void setInput2(String input2) {
		this.input2 = input2;
	}

	public List<String> getInputList() {
		return inputList;
	}

	public void setInputList(List<String> inputList) {
		this.inputList = inputList;
	}

}

	

