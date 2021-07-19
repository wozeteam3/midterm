/**
 * 
 */
package com.t3.midterm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import net.efabrika.util.DBTablePrinter;

/**
 * @author Aidan, Jacob, Brian
 *
 */
public class Driver {
	public static final Scanner kb = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/sakila";
		String user = "root";
		String password = "";
		
		//TODO switch to getStringInput()
		try {
			System.out.printf("Enter password for %s on %s\n", user, url);
			password = kb.nextLine();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			Connection c = DriverManager.getConnection(url, user, password);
			createEmployee(c,"a","b");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		kb.close();
	}
	
	public static int getIntegerInput() {
		int input = 0;
		try {
			input = kb.nextInt();
			kb.nextLine();
		} catch(Exception e) {
			System.out.println("Please enter only a number:\n");
		}
		return input;
	}
	
	public static String getStringInput() {
		String input = "";
		try {
			input = kb.next();
			kb.nextLine();
		} catch(Exception e) {
			System.out.println("Please enter valid input:\n");
		}
		return input;
	}
	
	public static void createEmployee(Connection c, String fName,String lName) {
		System.out.println(String.format("INSERT INTO ACTOR "
				+ "(first_name,last_name) VALUES ('%s','%s')",
				fName,lName));
		String query = String.format("INSERT INTO ACTOR "
				+ "(first_name,last_name) VALUES ('%s','%s')",
				fName,lName);
		Statement statement;
		try {
			statement = c.createStatement();
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
