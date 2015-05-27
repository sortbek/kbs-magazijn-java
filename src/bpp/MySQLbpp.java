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
    private Depository depository;
    private BoxDepository boxDepository;
    private ArrayList<Product> array = new ArrayList<Product>();
    private ArrayList<Box> arraybox = new ArrayList<Box>();
    private Product p;
    private Box b;

    public MySQLbpp() {
        this.myDriver = "com.mysql.jdbc.Driver";
        this.dbHost = "jdbc:mysql://jeffreywienen.nl/";
        this.dbName = "mydb";
        this.uName = "kbs";
        this.uPass = "Kbs123";
    }

    public void Products(Depository d) {
        depository = d;

        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);

            PreparedStatement stmt = con.prepareStatement("SELECT `ProductId`, `Check`, `Ordernr`, `idBox`,`Size` FROM `Robot_BPP` ");

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                String pNaam = "test" + result.getInt(1);
                Product p = new Product(pNaam, result.getInt(1), result.getInt(5));
                p.SetBox(result.getInt(4));
                d.addProduct(p);
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Where is the MySQL JDBC Driver?");
            System.out.println(e.getMessage());
        }
    }

    public void removeProduct(int productId) {
        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);

            PreparedStatement stmt = con.prepareStatement("DELETE FROM Robot_BPP WHERE ProductId = ?");
            stmt.setInt(1, productId);
            stmt.execute();
            System.out.println("Product removed from database.");
            con.close();
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Where is the MySQL JDBC Driver?");
            System.out.println(e.getMessage());
        }
    }

    public void Box(BoxDepository box) {

        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);

            PreparedStatement stmt = con.prepareStatement("SELECT `idBox`, `Size`, `Covered`, `idorder`, `print`, `Status` FROM `Box` WHERE `Status` = 'busy'");

            ResultSet result = stmt.executeQuery();

            int aantal = 0;
            while (result.next()) {
                Box b = new Box(result.getInt(1), result.getInt(2), result.getInt(3), result.getInt(4), result.getString(6));
                boxDepository = box;
                box.addBox(b);
                aantal = aantal + 1;
            }
            System.out.println("There are " + aantal + " boxes");
            if (aantal > 3) {
                System.out.println("There are more than 3 boxes");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Box SQLException");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Box Where is the MySQL JDBC Driver?");
            System.out.println(e.getMessage());
        }
    }

    void updateBox(int n_coveredSpace, boolean isFull, int boxId) {
        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);
            PreparedStatement stmt;
            if (isFull) {
                stmt = con.prepareStatement("UPDATE Box SET Covered = ?, Status = ? WHERE idBox = ?");
                stmt.setInt(1, n_coveredSpace);
                stmt.setString(2, "ready");
                stmt.setInt(3, boxId);
            } else {
                stmt = con.prepareStatement("UPDATE Box SET Covered = ? WHERE idBox = ?");
                stmt.setInt(1, n_coveredSpace);
                stmt.setInt(2, boxId);
            }
            stmt.executeUpdate();
            System.out.println("Update successful");
            con.close();
        } catch (SQLException e) {
            System.out.println("Update Box SQLException");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Update Box Where is the MySQL JDBC Driver?");
            System.out.println(e.getMessage());
        }
    }

    void updateResult(long t, int countb, int countp, int tsap, int tsab, String a) {
        int time;
        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);
            PreparedStatement stmt;

            stmt = con.prepareStatement("INSERT INTO `mydb`.`result_bbp` (`time`, `nr_result`, `count_box`, `count_product`, `total_size_all_products`, `total_size_all_box`, `algoritme`) VALUES (?, NULL, ?, ?, ?, ?, ?);");
            time = (int) t;
            stmt.setInt(1, time);
            stmt.setInt(2, countb);
            stmt.setInt(3, countp);
            stmt.setInt(4, tsap);
            stmt.setInt(5, tsab);
            stmt.setString(6, a);

            stmt.executeUpdate();
            System.out.println("Update successful");
            con.close();
        } catch (SQLException e) {
            System.out.println("Update Result SQLException");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Update Result Where is the MySQL JDBC Driver?");
            System.out.println(e.getMessage());
        }
    }

    void closeBox(int boxId) {
        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);
            PreparedStatement stmt;
            stmt = con.prepareStatement("UPDATE Box SET `Status` = 'ready' WHERE idBox = ?");
            stmt.setInt(1, boxId);
            stmt.execute();

            con.close();
        } catch (SQLException e) {
            System.out.println("Update Box SQLException");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Update Box Where is the MySQL JDBC Driver?");
            System.out.println(e.getMessage());
        }
    }

    public int NewBox(int size, int idorder) {
        int boxnr = 0;

        if (size == 5 | size == 10 | size == 20) {
            //controleren om mogelijke maten 
            try {
                Class.forName(myDriver);
                Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);
                PreparedStatement stmt = con.prepareStatement("INSERT INTO `mydb`.`Box` (`Size`, `Covered`, `idorder`, `Status`) VALUES (?, '0', ?, 'busy');");
                stmt.setInt(1, size);
                stmt.setInt(2, idorder);
                stmt.execute();

                //boxnr opvragen
                PreparedStatement stmt_box = con.prepareStatement("SELECT `idBox` FROM `Box` WHERE `Size` = ?");
                stmt_box.setInt(1, size);

                ResultSet result = stmt_box.executeQuery();

                while (result.next()) {
                    boxnr = result.getInt(1);

                }
                con.close();
            } catch (SQLException e) {
                System.out.println("SQLException NewBox");
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Where is the MySQL JDBC Driver?");
                System.out.println(e.getMessage());
            }

        } else {
        }
        return boxnr;
    }

    public void SetBox(int idbox, int idproduct) {
        int size;
        try {
            size = 0;

            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);
            PreparedStatement stmt = con.prepareStatement("UPDATE `mydb`.`Robot_BPP` SET `idBox` = ? WHERE `Robot_BPP`.`ProductId` = ?;");
            stmt.setInt(1, idbox);
            stmt.setInt(2, idproduct);
            stmt.execute();

            PreparedStatement stmt_Select = con.prepareStatement("SELECT `Size` FROM `Robot_BPP` WHERE `ProductId` = ?;");
            stmt_Select.setInt(1, idproduct);
            stmt_Select.execute();
            ResultSet result = stmt_Select.executeQuery();

            while (result.next()) {
                size = result.getInt(1);
            }

            PreparedStatement stmt_box = con.prepareStatement("UPDATE `mydb`.`Box` SET `Covered` = ? WHERE `Box`.`idBox` = ?; ");
            stmt_box.setInt(1, size);
            stmt_box.setInt(2, idbox);
            stmt_box.execute();

            System.out.println("Product " + idproduct + " was added to box " + idbox);

            con.close();
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Where is the MySQL JDBC Driver?");
            System.out.println(e.getMessage());
        }

    }

    public String SetNewProductsDB(int aantal, int idorder) {
        String SQL_s = "";
        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);

            PreparedStatement stmt = con.prepareStatement("INSERT INTO `mydb`.`SQL_codes` (`SQL_opdr`, `nr_opdr`) VALUES (?, NULL);");
            SQL_s = newProducts(aantal, idorder);
            stmt.setString(1, SQL_s);

            stmt.execute();
            System.out.println(SQL_s);
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Where is the MySQL JDBC Driver?");
            System.out.println(e.getMessage());
        }
        return SQL_s;
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
            SQL = "INSERT INTO `mydb`.`Robot_BPP` (`ProductId`, `Check`, `Ordernr`, `idBox`, `Size`) VALUES (NULL, NULL," + idorder + ", '0', " + size + ");";
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Where is the MySQL JDBC Driver?");
            System.out.println(e.getMessage());
        }
        return SQL;
    }

    public String newProducts(int aantal, int idorder) {
        String SQL = "";
        int size;

        for (int i = 0; i < aantal; i++) {
            Random rand = new Random();
            size = rand.nextInt(20) + 1;
            SQL = SQL + NewProduct(size, idorder);

        }
        return SQL;

    }

    public void DeleteProducts() {
        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);

            PreparedStatement stmt = con.prepareStatement("DELETE FROM `result_bbp` WHERE 1");

            stmt.execute();
            System.out.println("All products deleted");
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Where is the MySQL JDBC Driver?");
            System.out.println(e.getMessage());
        }

    }

    public void DeleteBox() {
        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);

            PreparedStatement stmt = con.prepareStatement("DELETE FROM `Box` WHERE 1");

            stmt.execute();
            System.out.println("All products deleted from the box");

        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Where is the MySQL JDBC Driver?");
            System.out.println(e.getMessage());
        }

    }

    public String SetNewProductsDB(String sql) {
        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(this.dbHost + this.dbName, this.uName, this.uPass);

            PreparedStatement stmt = con.prepareStatement("?");
            stmt.setString(1, sql);

            stmt.execute();
            System.out.println(sql + " succeeded");

        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Where is the MySQL JDBC Driver?");
            System.out.println(e.getMessage());
        }
        return sql;
    }

}
