/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpp;

import asrs.MainFrame;
import javax.swing.JFrame;
import bpp.BPPSimulatorGUI;
import java.util.ArrayList;

/**
 *
 * @author Marjolein
 */
public class BPP {
//   private ArrayList<Product> producten;
    
      /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                
                 Depository d = new Depository();
                BPPSimulatorGUI GUI = new BPPSimulatorGUI();
                GUI.setDepository(d);
               
                GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                GUI.setVisible(true); 
                
                
                //    MySQLbpp s = new bpp.MySQLbpßp();
                
   
//    s.Products();
//    producten = new ArrayList<>();
    Product p = new Product("trekker", 10,6);
    Product a = new Product("Schep", 12,7);
    Product b = new Product("Hark", 11,8);
    Product c = new Product("Spel", 16,7);
    Product d1 = new Product("Game", 17,9);
    d.addProduct(c);
    d.addProduct(b);
    d.addProduct(p);
    d.addProduct(d1);
    d.addProduct(a);
    GUI.setProducten(d.getList());
    GUI.Show();
    }
           } );
    
}
}
