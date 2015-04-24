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
                
                MySQLbpp bpp = new MySQLbpp();
                Depository d = new Depository();
                BoxDepository b = new BoxDepository();
               
                 
                BPPSimulatorGUI GUI = new BPPSimulatorGUI();
                GUI.setSQL(bpp);
                GUI.setDepository(d);
                bpp.Products(d);
                bpp.Box(b);
               
                GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                GUI.setVisible(true); 
                
                d.ShowArrayList();
                b.ShowArrayList();
    GUI.setProducten(d.getList());
//    GUI.Show();
    }
           } );
    
}
}