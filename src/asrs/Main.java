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

public class Main {

	public static void main(String[] args) {

		try {
			final String myDriver = "com.mysql.jdbc.Driver", 
					dbHost = "jdbc:mysql://jeffreywienen.nl/", 
					dbName = "mydb", 
					uName = "kbs", 
					uPass = "Kbs123";

			Class.forName(myDriver);
			Connection con = DriverManager.getConnection(dbHost + dbName,
					uName, uPass);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM user");

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				System.out.println(result.getString(1) + ": "
						+ result.getString(2));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
}