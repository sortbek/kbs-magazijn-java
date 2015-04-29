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
    private Product p;

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
        	while (producten.size() > j) {
                        p = producten.get(j);
                        sizet = sizet + p.Getsize();
                        j++;
		}
        return sizet;
    }
    
    public void BF(){
    int i = GetSizeOrder();
    
    // kiezen dozen
    while (i>20){
        // maak een doos van 20 groot aan
        i = i-20;
        System.out.println("doos gemaakt van 20");
        System.out.println(i);
    }
    while (i>10){
      // maak een doos van 10 groot aan
        i = i-10;
        System.out.println("doos gemaakt van 10");
        System.out.println(i);
    }
    while (i>1){
      // maak een doos van 5 groot aan
        i = i-5;
        System.out.println("doos gemaakt van 5");
        System.out.println(i);
    }
    }
    
    
}
