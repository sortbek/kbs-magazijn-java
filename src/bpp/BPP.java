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

                bpp.Box(b);
                BPPSimulatorGUI GUI = new BPPSimulatorGUI();
                GUI.setBoxDepository(b);
                GUI.setDepository(d);

                bpp.Products(d);
                GUI.SetTable();

                System.out.println("SimpleGreedy");
                SimpleGreedy sg = new SimpleGreedy();
                sg.setBoxDepository(b);
                sg.setDepository(d);
                //sg.runSg();
                
                System.out.println("BestFit");
                BestFit BF = new BestFit();
                BF.setBoxDepository(b);
                BF.setDepository(d);
                BF.BF();
                

                GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                GUI.setVisible(true);

                d.ShowArrayList();
                GUI.setProducten(d.getList());
            }
        });

    }
}
