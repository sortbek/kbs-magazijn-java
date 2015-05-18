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
   
   public int ShowArrayList(){
		while (producten.size() > j) {
			
                        p = producten.get(j);
			System.out.println(producten.get(j));
                        j++;
		}
    return j;
   }
   
   public int GetSizeArraylist(){
    return producten.size()+1;
    } 
   
    public int GetBigProduct() {
        // groot product
        int j = 0;
        int sizeb = 0;
        int nr = 0;
        	while (producten.size() > j) {
                    p = producten.get(j);
                        if (p.GetBox()==0){
                            if (sizeb < p.Getsize()){
                                sizeb = p.Getsize();
                                nr = j;
                            }
                        }j++;
                }
        System.out.println("grooste product is : "+ sizeb);
//        return sizeb;
        return nr;
        
    }
    
        public int GetSizeOrder() {
        // alle productmaten optellen
        int j = 0;
        int sizet = 0;
        	while (producten.size() > j) {
                    p = producten.get(j);
                     if (p.GetBox()==0){
                        if (p.GetBox()==0){
                        sizet = sizet + p.Getsize();
                        }
                     }
                        j++;
		}
        return sizet;
    }
        
                public int GetTotalSizeOrder() {
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
    
  public int GetSmallProduct(int s) {
        // groot product
        int j = 0;
        int sizeb = 0;
        int nr = 0;
        	while (producten.size() > j) {
                        p = producten.get(j);
                        if (p.GetBox()== 0){
                         if (s >= p.Getsize()){
                             
                             if (sizeb < p.Getsize()){
                         sizeb = p.Getsize();
                         nr = j;
                         }
                         }
                        }
                        j++;
		}
//        return sizeb;
                return nr;
    }
  
    public int GetProductWithSize(int s) {
        // groot product
        int j = 0;
        int nrProduct = 0;
        	while (producten.size() > j) {
                        p = producten.get(j);
                        if (p.GetBox()== 0){
                         if (s == p.Getsize()){
                             nrProduct = j;
//                         ProductId = p.GetidProduct();
//                         System.out.println ("productnr "+ ProductId);
                         }
                         }j++;
                        }
                        
                            return nrProduct;
		}
    
    
    
  
    
//        public int GetSmallestProduct(int s) {
//        // groot product
//        int j = 0;
//        int sizeb = 0;
//        	while (producten.size() > j) {
//                   
//                        p = producten.get(j);
//                         while (s <= p.Getsize()){
//                             if (j<s){
//                         sizeb = p.Getsize();
//                         }
//                         }
//                        j++;
//		}
//        return sizeb;
//    }

   
   public ArrayList<Product> getList(){
   return producten;
   }
}
