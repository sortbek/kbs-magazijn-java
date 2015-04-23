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
public class Depository extends BPPSimulatorGUI{
   private ArrayList<Product> producten;
   private int j = 0;
   private Product p;
        
   public Depository(){
   producten = new ArrayList<>();
   }
   
   
   public void addProduct(Product p){
   producten.add(p);
   }
   
   public void ShowArrayList(){
		while (producten.size() > j) {
			
                        p = producten.get(j);
			System.out.println(producten.get(j));
                        j++;
		}

   }
   
   public ArrayList<Product> getList(){
   return producten;
   }
}
