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
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                MySQLbpp bpp = new MySQLbpp();
                
                Depository d = new Depository();
                BoxDepository b = new BoxDepository();
//                SimpleGreedy sg = new SimpleGreedy();
                BPPSimulatorGUI GUI = new BPPSimulatorGUI();
                
                
                GUI.setBoxDepository(b);
                GUI.setDepository(d);
                
                bpp.Box(b);
                bpp.Products(d);
                GUI.SetTable();
//                bpp.closeBox(77);
//                bpp.SetBox(77, 16);

//                System.out.println("SimpleGreedy");
//                sg.setBoxDepository(b);
//                sg.setDepository(d);
//                sg.setBoxes();
//                sg.runSg();

                System.out.println("BestFit");
                BestFit BF = new BestFit();
                BF.setBoxDepository(b);
                BF.setDepository(d);
                BF.BF(10);


                GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                GUI.setVisible(true);

            }
        });

    }
}
