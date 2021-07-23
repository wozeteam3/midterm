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

	
	public static void deleteEmployee(Connection c, int toDeleteId) {
		System.out.println(String.format("DELETE * FROM employee WHERE EMP_ID = '%d'", toDeleteId));
		String query = String.format("DELETE * FROM employee WHERE EMP_ID = '%d'", toDeleteId);
		Statement statement;
		try {
			statement = c.createStatement();
			statement.execute(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Employee selectEmployee(Connection c, String lName, String fName) {
		Employee returnedEmployee = new Employee();
              String query = String.format("SELECT * FROM ACTOR WHERE FIRSTNAME = '%s' AND LASTNAME = '%s'", fName, lName);// %s %d overload to add id
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
			System.out.printf("Id: %d First Name: %s Last Name %d",  returnedEmployee.employeeId , returnedEmployee.firstName, returnedEmployee.LastName);
			return returnedEmployee;
		}
		catch(SQLException e) {
			e.printStackTrace();
			returnedEmployee = null;
			return returnedEmployee;
		}
		
	}
	
	public static Employee selectEmployee(Connection c, int idNumber) {
		Employee returnedEmployee = new Employee();
		System.out.println(String.format("SELECT * FROM employee WHERE EMP_ID = '%d'", idNumber));
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
			System.out.println("Id: " + returnedEmployee.employeeId + " First Name: " + returnedEmployee.firstName + " Last Name " + returnedEmployee.LastName);
			return returnedEmployee;
		}
		catch(SQLException e) {
			e.printStackTrace();
			returnedEmployee = null;
			return returnedEmployee;
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
    
  public static void welcomeMenu() {
		System.out.println("Welcome to Oh, CRUD");
		System.out.println("Oh, CRUD allows you to create, read, update, and delete data in a database.\nPress enter to continue");
		String r = kb.nextLine();
		boolean t = true;
		while (t = true) {
			System.out.println("            Oh Crud!      ");
			System.out.println("  Create Update Read Delete");
			System.out.println("Type the word or letter of what you would like to do?");
			System.out.println("For example if I want to delete a piece of data I would type Delete or d (casing doesn't matter) ");
			Scanner myObj = new Scanner(System.in);
			String enter = myObj.nextLine();
			String choice = enter.toLowerCase();
			if (choice.equals("create") || choice.equals("c")) {
				;
		
			}
			else if (choice.equals("update") || choice.equals("u")) {
				;
		
			}
			else if (choice.equals("read") || choice.equals("r")) {
				;
		
			}
			else if (choice.equals("delete") || choice.equals("d")) {
				;
			}
			else if (choice.equals("quit") || choice.equals("q")) {
				t=false;
				break;
			}
			else {
			System.out.println("Invalid input");
			}
		
		}
	}
	
  

}

