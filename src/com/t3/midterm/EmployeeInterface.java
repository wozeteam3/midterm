package com.t3.midterm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.sql.DataSource;

public class EmployeeInterface {
	static Scanner kb;
	static DataSource db;
	
	public EmployeeInterface(Scanner kb, DataSource db) {
		EmployeeInterface.kb = kb;
		this.db = db;
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

	public static void createEmployee(String fName, String lName) {
		String query = String.format("INSERT INTO ACTOR (first_name,last_name)"
								   + "VALUES ('%s','%s')",
								   	 fName, lName);
		try (
				Connection c = db.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
			) {
			ps.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteEmployee(int toDeleteId) {
		String query = String.format("DELETE * FROM employee"
								   + "WHERE EMP_ID = '%d'",
								     toDeleteId);
		Statement statement;
		try (
				Connection c = db.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
			) {
			ps.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Employee selectEmployee(String lName, String fName) {
		Employee returnedEmployee = new Employee();
		String query = String.format("SELECT * FROM ACTOR"
								   + "WHERE FIRSTNAME = '%s' AND LASTNAME = '%s'",
									 fName, lName);

		Statement statement;
		try (
				Connection c = db.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
			) {
			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				returnedEmployee.employeeId = rs.getInt(1);
				returnedEmployee.firstName = rs.getString(2);
				returnedEmployee.LastName = rs.getString(3);
			}
			return returnedEmployee;
		} catch (SQLException e) {
			e.printStackTrace();
			returnedEmployee = null;
			return returnedEmployee;
		}

	}

	public static Employee selectEmployee(int idNumber) {
		Employee returnedEmployee = new Employee();
		String query = String.format("SELECT * FROM employee"
								   + "WHERE EMP_ID = '%d'",
								   	 idNumber);
		Statement statement;
		try (
				Connection c = db.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
			) {
			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				returnedEmployee.employeeId = rs.getInt(1);
				returnedEmployee.firstName = rs.getString(2);
				returnedEmployee.LastName = rs.getString(3);
			}
			return returnedEmployee;
		} catch (SQLException e) {
			e.printStackTrace();
			returnedEmployee = null;
		}
		
		return returnedEmployee;
	}

	public static void updateEmployee(int idNumber, String fName, String lName) {
		String query = String.format("INSERT INTO employee (FIRSTNAME, LASTNAME)"
								   + "VALUES ('%s', '%s')"
								   + "WHERE EMP_ID = '%d'", 
								     fName, lName, idNumber);
		try (
				Connection c = db.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
			) {
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	
	static boolean isInt(String userInput) {
		for (int i = 0; i < userInput.length(); i++) {
			if (!Character.isDigit(userInput.charAt(i)))
				return false;
		}
		return true;
	}
}
