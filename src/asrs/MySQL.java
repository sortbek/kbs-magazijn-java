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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    public ArrayList<Order> fetchOrders(){
        ArrayList<Order> array = new ArrayList<Order>();   
        try{
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);    
            
            PreparedStatement stmt = con.prepareStatement("SELECT Order.idOrder, Order.Date, Customer.Firstname, Customer.Lastname, COUNT(Orderrow.order_idOrder) as 'Aantal product' FROM `Order` LEFT JOIN `Customer` ON Order.idCustomer=Customer.idCustomer LEFT JOIN `Orderrow` ON Orderrow.order_idOrder=Order.idOrder WHERE Order.State='QUEUED' GROUP BY Order.idOrder ORDER BY `Date`");
            
            ResultSet result = stmt.executeQuery();
            
            while (result.next()) {
                Customer c = new Customer();
                c.setFirstName(result.getString(3));
                c.setLastName(result.getString(4));
                Order order = new Order(result.getInt(1), c );
                order.setDate(result.getDate(2));
                fetchProducts(order);
                array.add(order);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } 
        return array;
    }
    public void fetchProducts(Order order){
        ArrayList<Product> products = new ArrayList<Product>();
        try{
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);
            
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Orderrow WHERE order_idOrder=?");
            stmt.setInt(1, order.getOrdernr());
            stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt(1));
                order.addProduct(product);
            }
            
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } 
    }
    public void insertOrder(Order order){
        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);
            
            Random rnd = new Random();
            int orderID = order.getOrdernr();
            int customerID = 100000 + rnd.nextInt(900000);
            
            PreparedStatement stmt = con.prepareStatement("INSERT INTO `Order` VALUES(?,?,?,?)");
            stmt.setInt(1, customerID);
            stmt.setInt(2, orderID);
            stmt.setDate(3, order.getDate());
            stmt.setString(4, order.getState().toString());
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
            
            //Create orderrow
            for(int i = 0; order.getProducts().size() > i; i++){
                PreparedStatement pstmt = con.prepareStatement("INSERT INTO Orderrow VALUES(?,?,?)");
                pstmt.setInt(1, order.getProducts().get(i).getId());
                pstmt.setInt(2, 1);
                pstmt.setInt(3, orderID);
                pstmt.execute();
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }        
    }
    public void updateOrderState(Order order, Order.State state){
        try{
            System.out.println(state.toString());
           Class.forName(myDriver);
           Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);
           PreparedStatement stmt = con.prepareStatement("UPDATE `Order` SET State='" + state.toString() + "' WHERE idOrder=" + order.getOrdernr() );
           stmt.execute();
           
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    public boolean findCustomer(){
        return false;
    }
}
