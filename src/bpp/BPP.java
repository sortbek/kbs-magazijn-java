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
                
                String algoritme = "";
                MySQLbpp bpp = new MySQLbpp();                
                Depository d = new Depository();
                BoxDepository b = new BoxDepository();
                SimpleGreedy sg = new SimpleGreedy();
                CompleteEnumeration cE = new CompleteEnumeration();
                BestFit BF = new BestFit();
                BPPSimulatorGUI GUI = new BPPSimulatorGUI();
                
                                
                GUI.setBoxDepository(b);
                GUI.setDepository(d);
                
                bpp.Box(b);
                bpp.Products(d);
                GUI.SetTable();
                GUI.setVisible(true);
                while (GUI.getDefaultCloseOperation()==0){
                algoritme = GUI.getAlgorith();
                
                if (algoritme == "Simple Greedy"){

                System.out.println("SimpleGreedy");
                sg.setBoxDepository(b);
                sg.setDepository(d);
                sg.setBoxes();
                sg.runSg();
                }
                else if(algoritme == "Best Enumeration"){
                System.out.println("Best Enumeration");
                
                BF.setBoxDepository(b);
                BF.setDepository(d);
                BF.BF(10);
                }
                else if(algoritme == "Complete Enumeration"){
                
                System.out.println("Complete Enumeration");
                cE.setBoxDepository(b);
                cE.setDepository(d);
                cE.setBoxes();
                cE.runCe();
                }
                }
                GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                

            }
        });

    }
}
