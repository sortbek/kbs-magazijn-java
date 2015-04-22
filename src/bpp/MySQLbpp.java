/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class MySQLbpp {
    private String myDriver;
    private String dbHost;
    private String dbName;
    private String uName;
    private String uPass;
    
    public MySQLbpp() {
        this.myDriver   = "com.mysql.jdbc.Driver";
        this.dbHost     = "jdbc:mysql://jeffreywienen.nl/";
        this.dbName     = "mydb";
        this.uName      = "kbs";
        this.uPass      = "Kbs123";
    }

    public void Products(){
           Depository d = new bpp.Depository();
           System.out.println("test productsMySQL");
        ArrayList<Product> array = new ArrayList<Product>();   
        
        try{
            Class.forName(myDriver);
              System.out.println("test productsMySQL1");
            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);    
            
            PreparedStatement stmt = con.prepareStatement("SELECT ProductId FROM Robot_BPP");
            
            ResultSet result = stmt.executeQuery();
            
           while (result.next()) {
                Product p = new Product("test",result.getInt(1),5); 
                System.out.println("test "+ result.getInt(1));
                d.addProduct(p);
            }
           System.out.println(array);
        } catch (SQLException e) {
            System.out.println("catch1");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Where is the MySQL JDBC Driver?");
            System.out.println(e.getMessage());
        } 
        d.ShowArrayList();
//        return array;
        
    }
    



}

