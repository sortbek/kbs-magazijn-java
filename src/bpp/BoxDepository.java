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
public class BoxDepository extends BPPSimulatorGUI {
 
   private ArrayList<Box> box;
   private int j = 0;
   private Box b;
        
   public BoxDepository(){
   box = new ArrayList<>();
   }
   
public void addBox(Box box){
   box.add(box);
   }
   
public void ShowArrayList(){
       // Show al the boxen in the BoxDepository
		while (box.size() > j) {
			
                        b = box.get(j);
			System.out.println(box.get(j));
                        System.out.println("**********************************");
                        j++;
		}
   } 

public int GetSizeArraylist(){
return box.size();
} 
   
public int GettotalSize(){
       int size = 0;
		while (box.size() > j) {
			
                        b = box.get(j);
                        size = size + b.getSizeB();
                        j++;
		}
                return size;
   }
   
//    public int GetCoverdBox(int b) {
//        // alle productmaten optellen
//        int j = 0;
//        int sizet = 0;
//        	while (producten.size() > j) {
//                        p = producten.get(j);
//                        if (p.GetBox()== b){
//                        sizet = sizet + p.Getsize();
//                        j++;
//                        System.out.println(sizet);
//		}}
//        return sizet;
//    }
           
   public ArrayList<Box> getList(){
   return box;
   }
}


