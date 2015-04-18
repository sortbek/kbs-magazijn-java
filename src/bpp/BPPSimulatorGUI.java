/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpp;

import java.util.ArrayList;

/**
 *
 * @author Hugo
 */
public class BPPSimulatorGUI extends javax.swing.JFrame {

    /**
     * Creates new form BPPSimulatorGUI
     */
    
    public BPPSimulatorGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bPPSimulatorBoxPanel2 = new bpp.BPPSimulatorBoxPanel();
        algorithmLabel = new javax.swing.JLabel();
        algorithmPicker = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jProgressBar1 = new javax.swing.JProgressBar();
        progressLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        packingData = new javax.swing.JTextArea();
        forceStop = new javax.swing.JButton();
        bPPSimulatorBoxPanel3 = new bpp.BPPSimulatorBoxPanel();

        javax.swing.GroupLayout bPPSimulatorBoxPanel2Layout = new javax.swing.GroupLayout(bPPSimulatorBoxPanel2);
        bPPSimulatorBoxPanel2.setLayout(bPPSimulatorBoxPanel2Layout);
        bPPSimulatorBoxPanel2Layout.setHorizontalGroup(
            bPPSimulatorBoxPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
        );
        bPPSimulatorBoxPanel2Layout.setVerticalGroup(
            bPPSimulatorBoxPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BPP-simulator");
        setResizable(false);

        algorithmLabel.setText("Algorithms");

        algorithmPicker.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Volledige enumeratie", "Simpel gretig", "Max rects" }));
        algorithmPicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                algorithmPickerActionPerformed(evt);
            }
        });

        productTable.setAutoCreateRowSorter(true);
        productTable.setFont(new java.awt.Font("Calibri", 0, 12));
        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"A", "10", "40", null, null},
                {"B", "50", "20", null, null},
                {"C", "20", "20", null, null},
                {"D", "100", "2", null, null}
            },
            new String [] {
                "Product", "Width", "Height", "Check", "Box"
            }
        ));
        jScrollPane1.setViewportView(productTable);

        progressLabel.setText("Progress");

        packingData.setEditable(false);
        packingData.setColumns(20);
        packingData.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        packingData.setRows(5);
        packingData.setText("Packing width:\nPacking height:\nArea covered:");
        jScrollPane2.setViewportView(packingData);

        forceStop.setBackground(new java.awt.Color(204, 0, 0));
        forceStop.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        forceStop.setForeground(new java.awt.Color(255, 255, 255));
        forceStop.setText("STOP THE PROCESS");

        javax.swing.GroupLayout bPPSimulatorBoxPanel3Layout = new javax.swing.GroupLayout(bPPSimulatorBoxPanel3);
        bPPSimulatorBoxPanel3.setLayout(bPPSimulatorBoxPanel3Layout);
        bPPSimulatorBoxPanel3Layout.setHorizontalGroup(
            bPPSimulatorBoxPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        bPPSimulatorBoxPanel3Layout.setVerticalGroup(
            bPPSimulatorBoxPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bPPSimulatorBoxPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(algorithmLabel)
                            .addComponent(algorithmPicker, 0, 239, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(progressLabel)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(forceStop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(0, 10, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(algorithmLabel)
                    .addComponent(progressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(algorithmPicker))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(forceStop, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bPPSimulatorBoxPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void algorithmPickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_algorithmPickerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_algorithmPickerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BPPSimulatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BPPSimulatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BPPSimulatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BPPSimulatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BPPSimulatorGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel algorithmLabel;
    private javax.swing.JComboBox algorithmPicker;
    private bpp.BPPSimulatorBoxPanel bPPSimulatorBoxPanel2;
    private bpp.BPPSimulatorBoxPanel bPPSimulatorBoxPanel3;
    private javax.swing.JButton forceStop;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea packingData;
    private javax.swing.JTable productTable;
    private javax.swing.JLabel progressLabel;
    // End of variables declaration//GEN-END:variables
}
