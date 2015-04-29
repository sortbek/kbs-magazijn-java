/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpp;

import java.util.ArrayList;

/**
 *
 * @author Marjolein
 */
public class BestFit {
    
     private Depository depository;
    private BoxDepository boxd;
    private ArrayList<Product> producten;
    private ArrayList<Box> arrayBox;
    private Box b;

    public BestFit() {

    }

    public void setBoxDepository(BoxDepository b) {
        boxd = b;
        arrayBox = boxd.getList();
        int a = arrayBox.size();
    }

    public void setDepository(Depository b) {
        this.depository = b;
        producten = depository.getList();
    }

    public Depository getDepository() {
        return this.depository;
    }

    public void setProducten(ArrayList<Product> p) {
        this.producten = p;
    }

    public int GetSizeOrder() {
        // alle productmaten optellen
        int j = 0;
        int sizet = 0;
        	while (arrayBox.size() > j) {
			
                        b = arrayBox.get(j);
                        sizet = sizet + b.getSizeB();
                        j++;
		}
        return sizet;
    }
    
}
