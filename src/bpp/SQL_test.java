/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpp;

/**
 *
 * @author Marjolein
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQL_test {

    private String myDriver;
    private String dbHost;
    private String dbName;
    private String uName;
    private String uPass;
    private Depository depository;
    private BoxDepository boxDepository;

    public SQL_test() {
        this.myDriver = "com.mysql.jdbc.Driver";
        this.dbHost = "jdbc:mysql://jeffreywienen.nl/";
        this.dbName = "mydb";
        this.uName = "kbs";
        this.uPass = "Kbs123";
    }
    
     public void NewBox(int size, int idorder) {
         if (size == 5|size == 10|size == 20){

//controleren om mogelijke maten 
        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);
            PreparedStatement stmt = con.prepareStatement("INSERT INTO `mydb`.`Box` (`Size`, `Covered`, `idorder`, `Status`) VALUES (?, '0', ?, 'busy');");
            stmt.setInt(1,size);
            stmt.setInt(2, idorder);
            stmt.execute();
            System.out.println("box is toegevoegd de box is "+ size +" groot");
//            while (result.next()) {
//                String pNaam = "test" + result.getInt(1);
//                Product p = new Product(pNaam, result.getInt(1), result.getInt(5));
//                d.addProduct(p);
//            }
//           System.out.println(array);
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Where is the MySQL JDBC Driver?");
            System.out.println(e.getMessage());
        }
    }
         else {    
             System.out.println("Kies een bestaande maat voor de box (5/10/20)");
         }
     }


public void SetBox(int idbox, int idproduct){
     try {
         // contoleren of box bestaat
         // contoleren of product bestaat
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);
            PreparedStatement stmt = con.prepareStatement("UPDATE `mydb`.`Robot_BPP` SET `idBox` = ? WHERE `Robot_BPP`.`ProductId` = ?;");
            stmt.setInt(1,idbox);
            stmt.setInt(2, idproduct);
            stmt.execute();
            System.out.println("product "+ idproduct +" is toegevoegd aan box "+ idbox );
//            while (result.next()) {
//                String pNaam = "test" + result.getInt(1);
//                Product p = new Product(pNaam, result.getInt(1), result.getInt(5));
//                d.addProduct(p);
//            }
//           System.out.println(array);
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Where is the MySQL JDBC Driver?");
            System.out.println(e.getMessage());
        }
}
}
    
    



