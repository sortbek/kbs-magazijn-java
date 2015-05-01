import bpp.BPPSimulatorGUI;
import javax.swing.JFrame;

import tsp.TSPSimulatorGUI;


public class Main {

	public static void main(String[] args) {

		
		//TO RUN TSP-SIMULATOR GUI
		
		
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TSPSimulatorGUI GUI = new TSPSimulatorGUI();
               GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               GUI.setVisible(true);
           }
        });
       
        
		
		//END OF RUN
	

	}

}
