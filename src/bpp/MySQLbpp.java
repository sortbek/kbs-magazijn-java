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

public class MySQLbpp {
    private String myDriver;
    private String dbHost;
    private String dbName;
    private String uName;
    private String uPass;
    private Depository depository;
    private BoxDepository boxDepository;
    private Box boxa;
    private Box boxc;
    private Box boxd;
    private Box boxb;
    private String a;
    private String b;
    private String c;
    private String d;
    private int box;
    private ArrayList<Box> arraybox;
    
    public MySQLbpp() {
        this.myDriver   = "com.mysql.jdbc.Driver";
        this.dbHost     = "jdbc:mysql://jeffreywienen.nl/";
        this.dbName     = "mydb";
        this.uName      = "kbs";
        this.uPass      = "Kbs123";
    }

    public void Products(Depository d){
           depository = d;
//        ArrayList<Product> array = new ArrayList<Product>();   
        
        try{
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);    
            
            PreparedStatement stmt = con.prepareStatement("SELECT `ProductId`, `Check`, `Ordernr`, `idBox` FROM `Robot_BPP`");
            
            ResultSet result = stmt.executeQuery();
            
           while (result.next()) {
                Product p = new Product("test",result.getInt(1),5); 
                d.addProduct(p);
            }
//           System.out.println(array);
        } catch (SQLException e) {
            System.out.println("Product SQLException");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Product Where is the MySQL JDBC Driver?");
            System.out.println(e.getMessage());
        } 
    }
    
     public void Box(BoxDepository boxD){
          boxDepository = boxD;
        
        try{
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);    
            
            PreparedStatement stmt = con.prepareStatement("SELECT `idBox`, `Size`, `Covered`, `idorder`, `print`, `Status` FROM `Box` WHERE `Status` = 'busy'");
            
            ResultSet result = stmt.executeQuery();
            
           while (result.next()) {
               if (box == 0){
               boxa = new Box(result.getInt(1),result.getInt(2),result.getInt(3),result.getInt(4));
               a = boxa.toString();
               boxDepository.addBox(boxa);
               }
               else if (box == 1){
               boxb = new Box(result.getInt(1),result.getInt(2),result.getInt(3),result.getInt(4));
               b = boxb.toString();
               boxDepository.addBox(boxb);
               }
               else if (box == 2){
               boxc = new Box(result.getInt(1),result.getInt(2),result.getInt(3),result.getInt(4));
               c = boxc.toString();
               boxDepository.addBox(boxc);
               }
               else if (box > 2){
               boxd = new Box(result.getInt(1),result.getInt(2),result.getInt(3),result.getInt(4));
               d = boxd.toString();
               System.out.println("meer dan 3 boxen");
               boxDepository.addBox(boxd);
               }
               
               this.box = box +1;
                
            }
           boxDepository.ShowArrayList();
           arraybox = boxDepository.getList();
           Box test = arraybox.get(0);
           System.out.println("test "+ test);
           
           
           
//           System.out.println(array);
        } catch (SQLException e) {
            System.out.println("BoxSQLException");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Box Where is the MySQL JDBC Driver?");
            System.out.println(e.getMessage());
        } 
    }
     
     public Box getBoxA(){
     return boxa;
     }
     
     public Box getBoxB(){
     return boxb;
     }
     
     public Box getBoxC(){
     return boxc;
     }
     
     public Box getBoxD(){
     return boxd;
     }
     
      public String sgetBoxA(){
     return a;
     }
     
     public String sgetBoxB(){
     return b;
     }
     
     public String sgetBoxC(){
     return c;
     }
     
     public String sgetBoxD(){
     return d;
     }
    



}

