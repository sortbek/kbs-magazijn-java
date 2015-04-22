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
public class Depository {
   private ArrayList<Product> producten = new ArrayList<>(); 
   private int j = 0;
   
   Product p = new Product("trekker", 10);
    Product a = new Product("Schep", 12);
     Product b = new Product("Hark", 11);
      Product c = new Product("Spel", 16);
       Product d = new Product("Game", 17);
       
 
   
   public void addProduct(Product p){
   producten.add(p);
   }
   
   public void ShowArrayList(){
		while (producten.size() > j) {
			System.out.println(producten.get(j));
			j++;
		}
   }
}
