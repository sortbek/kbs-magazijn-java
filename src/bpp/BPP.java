/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpp;

import asrs.MainFrame;
import javax.swing.JFrame;
import bpp.BPPSimulatorGUI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
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
                
                String algoritme = "Best Fit";
                MySQLbpp bpp = new MySQLbpp();                
                Depository d = new Depository();
                BoxDepository b = new BoxDepository();
                SimpleGreedy sg = new SimpleGreedy();
                CompleteEnumeration cE = new CompleteEnumeration();
                BestFit BF = new BestFit();
                BPPSimulatorGUI GUI = new BPPSimulatorGUI();
                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                Long time;
                
                
                                
                GUI.setBoxDepository(b);
                GUI.setDepository(d);
                
                bpp.Box(b);
                bpp.Products(d);
                
                GUI.setVisible(true);
                
                Date date_start = new Date();
                System.out.println(dateFormat.format(date_start)); // 15:59:48
                
                if (algoritme == "Simple Greedy"){

                System.out.println("SimpleGreedy");
                sg.setBoxDepository(b);
                sg.setDepository(d);
                sg.setBoxes();
                sg.runSg();
                }
                else if(algoritme == "Best Fit"){
                System.out.println("Best Fit");
                
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
                
                Date date_stop = new Date();
                System.out.println(dateFormat.format(date_stop)); // 15:59:48
                time = date_stop.getTime() - date_start.getTime();
                time = time/1000;
                
                GUI.SetTable();
                

                // resultaat opslaan 
                
                bpp.updateResult(time, b.GetSizeArraylist(), d.GetSizeArraylist(), d.GetTotalSizeOrder(), b.GettotalSize(), algoritme);
//                System.out.println("tijd :"+ time);
//                System.out.println("aantal producten "+ d.GetSizeArraylist()+ " totale groote " + d.GetSizeOrder());
//                System.out.println("aantal boxen " + b.GetSizeArraylist() + " totale volume boxen " + b.GettotalSize());
                
                GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                

            }
        });

    }
}