/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpp;

import bpp.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Marjolein
 */
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

    public ArrayList<Product> Products(){
        ArrayList<Product> array = new ArrayList<Product>();   
        try{
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);    
            
            PreparedStatement stmt = con.prepareStatement("Select Robot_BPP.ProductId From Robot_BPP");
            
            ResultSet result = stmt.executeQuery();
            
           while (result.next()) {
                Product p = new Product(result.getString(1),result.getInt(2)); 
                array.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } 
        return array;
    }
    



}

