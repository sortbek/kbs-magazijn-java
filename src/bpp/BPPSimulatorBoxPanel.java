package bpp;

import java.awt.*;
import javax.swing.*;

public class BPPSimulatorBoxPanel extends JPanel {

    public BPPSimulatorBoxPanel() {
        this.setPreferredSize(new Dimension(489, 140));
        setLayout(new FlowLayout());
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(50, 10, 100, 100);
        g.drawRect(200, 10, 100, 100);
        g.drawRect(350, 10, 100, 100);

        g.drawString("Box A", 85, 125);
        g.drawString("Box B", 235, 125);
        g.drawString("Box C", 385, 125);
    }

    public static void main(String args[]) {
        BPPSimulatorBoxPanel panel = new BPPSimulatorBoxPanel();

    }

}
