/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asrs;

/**
 *
 * @author jeffreywienen
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class MySQL {
    private String myDriver;
    private String dbHost;
    private String dbName;
    private String uName;
    private String uPass;
    
    public MySQL() {
        this.myDriver   = "com.mysql.jdbc.Driver";
        this.dbHost     = "jdbc:mysql://jeffreywienen.nl/";
        this.dbName     = "mydb";
        this.uName      = "kbs";
        this.uPass      = "Kbs123";
    }
    
    public void fetchOrders(){
        
    }
    
    public void insertOrder(Order order){
        try {
            final String myDriver   = this.myDriver,
                    dbHost          = this.dbHost,
                    dbName          = this.dbName,
                    uName           = this.uName,
                    uPass           = this.uPass;

            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(dbHost + dbName, uName, uPass);
            
            Random rnd = new Random();
            int orderID = 100000 + rnd.nextInt(900000);
            int customerID = 100000 + rnd.nextInt(900000);
            
            PreparedStatement stmt = con.prepareStatement("INSERT INTO `Order` VALUES(?,?)");
            stmt.setInt(1, customerID);
            stmt.setInt(2,orderID);
            stmt.execute();
            
            //Insert customer (if customer is new)
            if(!findCustomer()){
                PreparedStatement cstmt = con.prepareStatement("INSERT INTO Customer(idCustomer, FirstName, LastName, Address, Zipcode, City) VALUES(?,?,?,?,?,?)");
                cstmt.setInt(1, customerID);
                cstmt.setString(2, order.getC().getFirstName());
                cstmt.setString(3, order.getC().getLastName());
                cstmt.setString(4, order.getC().getAddress());
                cstmt.setString(5, order.getC().getZipcode());
                cstmt.setString(6, order.getC().getCity());
                cstmt.execute();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }        
    }
    
    public boolean findCustomer(){
        return false;
    }
}
