package tsp;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TSPSimulatorGUI GUI = new TSPSimulatorGUI();
               GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               GUI.setVisible(true);
           }
        });
	}

}
