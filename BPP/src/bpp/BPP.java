/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpp;

import java.awt.*;
import javax.swing.*;

public class BPP extends JFrame {

    private String[] algorithms = { "a1", "a2", "a3" };
    private JComboBox algorithmPicker;    
    
    public BPP() {
        setSize(400, 400);
        setTitle("BPP-simulator");
        setLayout(new FlowLayout());

        algorithmPicker = new JComboBox(algorithms);
        add(algorithmPicker);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BPP BPP = new BPP();
    }

}
