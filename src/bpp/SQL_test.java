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

import static com.sun.org.apache.xalan.internal.lib.ExsltMath.random;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import static jdk.nashorn.internal.objects.NativeMath.random;

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
    
     public String NewProduct(int size, int idorder) {
         String SQL = "";
        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);

            PreparedStatement stmt = con.prepareStatement("INSERT INTO `mydb`.`Robot_BPP` (`ProductId`, `Check`, `Ordernr`, `idBox`, `Size`) VALUES (NULL, NULL, ?, '0', ?);");
                stmt.setInt(1, idorder);
                stmt.setInt(2, size);
            
            stmt.execute();
            SQL = "INSERT INTO `mydb`.`Robot_BPP` (`ProductId`, `Check`, `Ordernr`, `idBox`, `Size`) VALUES (NULL, NULL,"+idorder+", '0', "+size+")";
            
            
//           System.out.println(array);
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Where is the MySQL JDBC Driver?");
            System.out.println(e.getMessage());
        }
        return SQL;
     }

public String newProducts (int aantal, int idorder){
String SQL = "";
int size;

for(int i=0; i<aantal; i++){
Random rand = new Random();
size = rand.nextInt(20) + 1;
SQL = SQL + NewProduct(size,idorder);

}
return SQL;

}

public String SetNewProductsDB (int aantal, int idorder){
         String SQL_s = "";
        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);

            PreparedStatement stmt = con.prepareStatement("INSERT INTO `mydb`.`SQL_codes` (`SQL_opdr`, `nr_opdr`) VALUES (?, NULL);");
                SQL_s = newProducts(aantal,idorder);
                stmt.setString(1,SQL_s);

            stmt.execute(); 
            System.out.println(SQL_s);
           
            
            
//           System.out.println(array);
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Where is the MySQL JDBC Driver?");
            System.out.println(e.getMessage());
        }
        return SQL_s;
     }




}

    
    



