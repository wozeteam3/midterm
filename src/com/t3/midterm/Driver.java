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

	public static void updateEmployee(Connection c) {
		 System.out.println("How many columns will you be updating?\n");
		 var input = new Scanner (System.in);
		 String numOfValues = input.nextLine();
		 if (numOfValues == "3") {
			 System.out.println("Enter the new Employee id:\n");
			 String employeeId = input.nextLine();
			 System.out.println("Enter the new first name\n ");
			 String firstName = input.nextLine();
			 System.out.println("Enter the new last name\n");
			 String lastName = input.nextLine();
			 System.out.println("Enter a row value where these new values are going.");
			 String whereValue =input.nextLine();
			 System.out.println("Enter what column that value is in.");
			 String whereColumn = input.nextLine();
			 String query = String.format("UPDATE sakila.actor SET employee_id = " + employeeId + ",  first_name = " + firstName +", last_name = "+ lastName +"WHERE " + whereColumn + " = " + whereValue);
			 Statement statement;
				try {
					statement = c.createStatement();
					statement.execute(query);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 
		 }
		 else if (numOfValues=="2") {
			System.out.println("Enter a column that the first value is going to (actor_id,first_name,last_name)");
			String set1 = input.nextLine();
			System.out.println("Enter a column that the second value is going to (actor_id,first_name,last_name)");
			String set2 = input.nextLine();
			System.out.println("Enter the first value");
			String value1 = input.nextLine();
			System.out.println("Enter the second value");
			String value2 = input.nextLine();
			System.out.println("Enter a row value where this is going");
			String whereValue =input.nextLine();
			System.out.println("Enter what column that value is in");
			String whereColumn = input.nextLine();
			String query = String.format("UPDATE sakila.actor SET " + set1.toLowerCase() + " = " + value1 + ", " + set2.toLowerCase() + " = " + value2 + "WHERE " + whereColumn.toLowerCase() + " = " + whereValue);
			Statement statement;
			try {
				statement = c.createStatement();
				statement.execute(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		 
		 }
		 else if (numOfValues=="1") {
			 System.out.println("Enter the column that the value is going to (actor_id,first_name,last_name)");
			 String set = input.nextLine();
			 System.out.println("Enter the value");
			 String value = input.nextLine();
			 System.out.println("Enter a row value where this is going");
			 String whereValue =input.nextLine();
			 System.out.println("Enter what column that value is in");
			 String whereColumn = input.nextLine();
			 String query = String.format("UPDATE sakila.actor SET " + set.toLowerCase() + " = " + value + "WHERE " + whereColumn.toLowerCase() + " = " + whereValue);
			 Statement statement;
				try {
					statement = c.createStatement();
					statement.execute(query);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		 
		 }
	}
}
