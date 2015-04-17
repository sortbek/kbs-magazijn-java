package bpp;

import java.awt.*;
import javax.swing.*;

public class BPPSimulatorBoxPanel extends JPanel {

    private BPPSimulatorGUI gui;
    private int height, width, space;

    public BPPSimulatorBoxPanel() {
        this.setPreferredSize(new Dimension(489, 200));
        setLayout(new FlowLayout());
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(50, 90, 100, 100);
        g.drawRect(200, 90, 100, 100);
        g.drawRect(350, 90, 100, 100);
        
        g.drawString("Box A", 85, 135);
        g.drawString("Box B", 235, 135);
        g.drawString("Box C", 385, 135);
    
    }

    public static void main(String args[]) {
        BPPSimulatorBoxPanel panel = new BPPSimulatorBoxPanel();        
        
    }

    }
