/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpp;

import java.util.Random;

/**
 *
 * @author Marjolein
 */
class random extends Random {
    

 public static void main(String[] args) {
     
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                
                MySQLbpp rand = new MySQLbpp();
                String sql = rand.SetNewProductsDB( 20, 129);
//                rand.SetNewProductsDB(sql);

}
        });
                }
}