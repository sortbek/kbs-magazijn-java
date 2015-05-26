/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpp;

//import bpp.Box;
//import bpp.BoxDepository;
//import bpp.Depository;
//import bpp.Product;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//public class MakeNewProducts {
//
//    private String myDriver;
//    private String dbHost;
//    private String dbName;
//    private String uName;
//    private String uPass;
//
//
//    public MakeNewProducts() {
//        this.myDriver = "com.mysql.jdbc.Driver";
//        this.dbHost = "jdbc:mysql://jeffreywienen.nl/";
//        this.dbName = "mydb";
//        this.uName = "kbs";
//        this.uPass = "Kbs123";
//    
//
////    public void MakeNewProducts(){
////            Class.forName(myDriver);
////            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);
////
////            PreparedStatement stmt = con.prepareStatement("SELECT `ProductId`, `Check`, `Ordernr`, `idBox`,`Size` FROM `Robot_BPP` ");
////
////            ResultSet result = stmt.executeQuery();
////            while (result.next()) {
////                String pNaam = "test" + result.getInt(1);
////                Product p = new Product(pNaam, result.getInt(1), result.getInt(5));
////                p.SetBox(result.getInt(4));
////                d.addProduct(p);
////            }
//////           System.out.println(array);
////        } catch (SQLException e) {
////            System.out.println("SQLException");
////            System.out.println(e.getMessage());
////        } catch (ClassNotFoundException e) {
////            System.out.println("Where is the MySQL JDBC Driver?");
////            System.out.println(e.getMessage());
////        }
//    
//
////  
////
////            PreparedStatement stmt = con.prepareStatement("DELETE FROM Robot_BPP WHERE ProductId = ?");
////            stmt.setInt(1, productId);
////            stmt.execute();
////            System.out.println("Product removed from database.");
//////           System.out.println(array);
////        } catch (SQLException e) {
////            System.out.println("SQLException");
////            System.out.println(e.getMessage());
////        } catch (ClassNotFoundException e) {
////            System.out.println("Where is the MySQL JDBC Driver?");
////            System.out.println(e.getMessage());
////        }
////    }
////
////    public void Box(BoxDepository box) {
////
////        try {
////            Class.forName(myDriver);
////            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);
////
////            PreparedStatement stmt = con.prepareStatement("SELECT `idBox`, `Size`, `Covered`, `idorder`, `print`, `Status` FROM `Box` WHERE `Status` = 'busy'");
////
////            ResultSet result = stmt.executeQuery();
////
////            int aantal = 0;
////            while (result.next()) {
////                Box b = new Box(result.getInt(1), result.getInt(2), result.getInt(3), result.getInt(4), result.getString(6));
////                boxDepository = box;
////                box.addBox(b);
////                aantal = aantal + 1;
////            }
////            System.out.println("Aantal boxen is: " + aantal);
////            if (aantal > 3) {
////                System.out.println("Er zijn meer dan drie boxen");
////            }
////
////        } catch (SQLException e) {
////            System.out.println("Box SQLException");
////            System.out.println(e.getMessage());
////        } catch (ClassNotFoundException e) {
////            System.out.println("Box Where is the MySQL JDBC Driver?");
////            System.out.println(e.getMessage());
////        }
////    }
////
////    void updateBox(int n_coveredSpace, boolean isFull, int boxId) {
////        try {
////            Class.forName(myDriver);
////            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);
////            PreparedStatement stmt;
////            if (isFull) {
////                stmt = con.prepareStatement("UPDATE Box SET Covered = ?, Status = ? WHERE idBox = ?");
////                stmt.setInt(1, n_coveredSpace);
////                stmt.setString(2, "ready");
////                stmt.setInt(3, boxId);
////            } else {
////                stmt = con.prepareStatement("UPDATE Box SET Covered = ? WHERE idBox = ?");
////                stmt.setInt(1, n_coveredSpace);
////                stmt.setInt(2, boxId);
////            }
////            stmt.executeUpdate();
////            System.out.println("Update successful");
////        } catch (SQLException e) {
////            System.out.println("Update Box SQLException");
////            System.out.println(e.getMessage());
////        } catch (ClassNotFoundException e) {
////            System.out.println("Update Box Where is the MySQL JDBC Driver?");
////            System.out.println(e.getMessage());
////        }
////    }
////
////    void closeBox(int boxId) {
////        try {
////            Class.forName(myDriver);
////            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);
////            PreparedStatement stmt;
////            stmt = con.prepareStatement("UPDATE Box SET `Status` = 'ready' WHERE idBox = ?");
////            stmt.setInt(1, boxId);
////            stmt.execute();
////
////        } catch (SQLException e) {
////            System.out.println("Update Box SQLException");
////            System.out.println(e.getMessage());
////        } catch (ClassNotFoundException e) {
////            System.out.println("Update Box Where is the MySQL JDBC Driver?");
////            System.out.println(e.getMessage());
////        }
////    }
////
////    public int NewBox(int size, int idorder) {
////        int boxnr = 0;
////
////        if (size == 5 | size == 10 | size == 20) {
////            //controleren om mogelijke maten 
////            try {
////                Class.forName(myDriver);
////                Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);
////                PreparedStatement stmt = con.prepareStatement("INSERT INTO `mydb`.`Box` (`Size`, `Covered`, `idorder`, `Status`) VALUES (?, '0', ?, 'busy');");
////                stmt.setInt(1, size);
////                stmt.setInt(2, idorder);
////                stmt.execute();
////
////                //boxnr opvragen
////                PreparedStatement stmt_box = con.prepareStatement("SELECT `idBox` FROM `Box` WHERE `Size` = ?");
////                stmt_box.setInt(1, size);
////
////                ResultSet result = stmt_box.executeQuery();
////
////                while (result.next()) {
////                    boxnr = result.getInt(1);
////
////                }
////
////                System.out.println("box is toegevoegd de box is " + size + " groot en het nr : " + boxnr);
////
////            } catch (SQLException e) {
////                System.out.println("SQLException NewBox");
////                System.out.println(e.getMessage());
////            } catch (ClassNotFoundException e) {
////                System.out.println("Where is the MySQL JDBC Driver?");
////                System.out.println(e.getMessage());
////            }
////
////        } else {
////            System.out.println("Kies een bestaande maat voor de box (5/10/20)");
////        }
////        return boxnr;
////    }
////
////    public void SetBox(int idbox, int idproduct) {
////        int size;
////        try {
////            size = 0;
////
////            Class.forName(myDriver);
////            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);
////            PreparedStatement stmt = con.prepareStatement("UPDATE `mydb`.`Robot_BPP` SET `idBox` = ? WHERE `Robot_BPP`.`ProductId` = ?;");
////            stmt.setInt(1, idbox);
////            stmt.setInt(2, idproduct);
////            stmt.execute();
////
////            PreparedStatement stmt_Select = con.prepareStatement("SELECT `Size` FROM `Robot_BPP` WHERE `ProductId` = ?;");
////            stmt_Select.setInt(1, idproduct);
////            stmt_Select.execute();
////            ResultSet result = stmt_Select.executeQuery();
////
////            while (result.next()) {
////                size = result.getInt(1);
////            }
////
////            PreparedStatement stmt_box = con.prepareStatement("UPDATE `mydb`.`Box` SET `Covered` = ? WHERE `Box`.`idBox` = ?; ");
////            stmt_box.setInt(1, size);
////            stmt_box.setInt(2, idbox);
////            stmt_box.execute();
////
////            System.out.println("product " + idproduct + " is toegevoegd aan box " + idbox);
////
////        } catch (SQLException e) {
////            System.out.println("SQLException");
////            System.out.println(e.getMessage());
////        } catch (ClassNotFoundException e) {
////            System.out.println("Where is the MySQL JDBC Driver?");
////            System.out.println(e.getMessage());
////        }
////
////    }
//
//
//
