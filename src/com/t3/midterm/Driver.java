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

		// TODO switch to getStringInput()
		try {
			System.out.printf("Enter password for %s on %s\n", user, url);
			password = kb.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Connection c = DriverManager.getConnection(url, user, password);
			createEmployee(c, "a", "b");
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
		} catch (Exception e) {
			System.out.println("Please enter only a number:\n");
		}
		return input;
	}

	public static String getStringInput() {
		String input = "";
		try {
			input = kb.next();
			kb.nextLine();
		} catch (Exception e) {
			System.out.println("Please enter valid input:\n");
		}
		return input;
	}

	static boolean isInt(String userInput) {
		for (int i = 0; i < userInput.length(); i++) {
			if (!Character.isDigit(userInput.charAt(i)))
				return false;
		}
		return true;
	}

	public static void createEmployee(Connection c, String fName, String lName) {
		String query = String.format("INSERT INTO ACTOR " + "(first_name,last_name) VALUES ('%s','%s')", fName, lName);
		Statement statement;
		try {
			statement = c.createStatement();
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteEmployee(Connection c, int toDeleteId) {
		String query = String.format("DELETE * FROM employee WHERE EMP_ID = '%d'", toDeleteId);
		Statement statement;
		try {
			statement = c.createStatement();
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Employee selectEmployee(Connection c, String lName, String fName) {
		Employee returnedEmployee = new Employee();
		String query = String.format("SELECT * FROM ACTOR WHERE FIRSTNAME = '%s' AND LASTNAME = '%s'", fName, lName);// %s
																														// %d
																														// overload
																														// to
																														// add
																														// id
		System.out.println(query);

		Statement statement;
		try {
			statement = c.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				returnedEmployee.employeeId = rs.getInt(1);
				returnedEmployee.firstName = rs.getString(2);
				returnedEmployee.LastName = rs.getString(3);
			}
			System.out.printf("Id: %d First Name: %s Last Name %d", returnedEmployee.employeeId,
					returnedEmployee.firstName, returnedEmployee.LastName);
			return returnedEmployee;
		} catch (SQLException e) {
			e.printStackTrace();
			returnedEmployee = null;
			return returnedEmployee;
		}

	}

	public static Employee selectEmployee(Connection c, int idNumber) {
		Employee returnedEmployee = new Employee();
		String query = String.format("SELECT * FROM employee WHERE EMP_ID = '%d'", idNumber);// %s %d overload to add id
		Statement statement;
		try {
			statement = c.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				returnedEmployee.employeeId = rs.getInt(1);
				returnedEmployee.firstName = rs.getString(2);
				returnedEmployee.LastName = rs.getString(3);
			}
			System.out.println("Id: " + returnedEmployee.employeeId + " First Name: " + returnedEmployee.firstName
					+ " Last Name " + returnedEmployee.LastName);
			return returnedEmployee;
		} catch (SQLException e) {
			e.printStackTrace();
			returnedEmployee = null;
			return returnedEmployee;
		}

	}

	public static void updateEmployee(Connection c) {

	}

	public static String[] inputName() {
		String[] fullName = new String[2];
		System.out.println("What is the employee's first name?");
		fullName[0] = kb.nextLine();
		System.out.println("What is the employee's last name?");
		fullName[1] = kb.nextLine();
		return fullName;
	}

	public static int inputId() {
		System.out.println("What is the employee's ID number?");
		int idNumber = kb.nextInt();
		return idNumber;

	}

}
