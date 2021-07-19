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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/sakila";
		String user = "root";
		String password = "";
		try(Scanner kb  = new Scanner(System.in)) {
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
		

	}
	
	static boolean isInt(String userInput)
    {
        for (int i = 0; i < userInput.length(); i++) {
            if (Character.isDigit(userInput.charAt(i)) == false)
                return false;
        } 
        return true;
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
	
	public static void deleteEmployee(Connection c) {
		//Once selectEmployee is created empID will be employeeToRemove.
		//Employee employeeToRemove = selectEmployee();
		int empID = 0;
		System.out.println(String.format("DELETE * FROM ACTOR WHERE actor_id = " + empID));
		String query = String.format("DELETE * FROM Actor WHERE actor_id = " + empID);
		Statement statement;
		try {
			statement = c.createStatement();
			statement.execute(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
