package bpp;

import asrs.MainFrame;
import javax.swing.JFrame;
import bpp.BPPSimulatorGUI;
import java.util.ArrayList;

public class BPP implements Runnable {

    @Override
    public void run() {
        MySQLbpp bpp = new MySQLbpp();

        Depository d = new Depository();
        BoxDepository b = new BoxDepository();
        SimpleGreedy sg = new SimpleGreedy();

        bpp.Box(b);
        bpp.Products(d);

        System.out.println("SimpleGreedy");
        sg.setBoxDepository(b);
        sg.setDepository(d);
        sg.setBoxes();
        sg.runSg();
//
//                System.out.println("BestFit");
//                BestFit BF = new BestFit();
//                BF.setBoxDepository(b);
//                BF.setDepository(d);
//                BF.BF(26);
//                BF.GetCoverdBox(30);

//                System.out.println("zit .. in" + d.GetCoverdBox(41));
//                
//                
//                CompleteEnumeration cE = new CompleteEnumeration();
//                cE.setBoxDepository(b);
//                cE.setDepository(d);
//                cE.setBoxes();
//                cE.runCe();
        BPPSimulatorGUI GUI = new BPPSimulatorGUI();
        bpp.Box(b);

        GUI.setBoxDepository(b);
        GUI.setDepository(d);
        GUI.SetTable();

        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.setVisible(true);

    }

    public static void main(String[] args) {
        (new Thread(new BPP())).start();

    }

}
