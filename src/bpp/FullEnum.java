/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpp;

import java.util.ArrayList;
//import java.util.Arrays;

/**
 *
 * @author Nick HS
 */
public class FullEnum {

    //private Depository depository;
    //private BoxDepository boxd;
    private ArrayList<Product> producten;
    private ArrayList<Box> arrayBox;
    //private Box b;

    public FullEnum() {
    }

    public void setProducten(ArrayList<Product> p) {
        this.producten = p;
    }
    
    public void setBoxen(ArrayList<Box> b) {
        this.arrayBox = b;
    }
    
    public void enum$0() {
        int count = 0;
        int totalProductSize = 0;
        while (count < producten.size()) {
            //execute this code;
            totalProductSize = totalProductSize + producten.size();
            count++;
        }
    }
    
    public void enum$1() {
        int count = 0;
        int totalBoxSize = 0;
        while (count < arrayBox.size()) {
            //execute this code;
            totalBoxSize = totalBoxSize + arrayBox.size();
            count++;
        }
    }

}
