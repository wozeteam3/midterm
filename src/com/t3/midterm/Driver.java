/**
 * 
 */
package com.t3.midterm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.efabrika.util.DBTablePrinter;

/**
 * @author Aidan, Jacob, Brian
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/sakila";
		String user = "root";
		String password = "";
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("Successful");
			String query = "SELECT * FROM ACTOR LIMIT 5";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			DBTablePrinter.printResultSet(rs);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

	}

}
