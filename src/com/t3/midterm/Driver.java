package com.t3.midterm;

import java.util.Scanner;
import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * Contains main method and handles user interface
 */
public class Driver {
	/**
	 * Scanner to be used throughout build for keyboard input so that it can be
	 * closed only at the end as Scanner.close() affects all scanners.
	 */
	public static final Scanner kb = new Scanner(System.in);
	
	/**
	 * URL of MySQL DB
	 */
	public static final String DB_URL = "jdbc:mysql://localhost:3306/midterm";
	
	/**
	 * Username for DB
	 */
	public static final String USER = "root";

	/**
	 * Main method that performs login and starts menu.
	 * @param args <i>Unused</i>
	 */
	public static void main(String[] args) {
		DataSource db = login();
		
		EmployeeInterface employeeDB = new EmployeeInterface(db);
		
		welcomeMenu(employeeDB);

		kb.close();
	}
	
	/**
	 * Prints an interface with options for user and repeats after each operation
	 * until the user quits  
	 * @param db The EmployeeInterface which will perform operations
	 */
	public static void welcomeMenu(EmployeeInterface db) {
		System.out.println("--------------------------------");
		System.out.println("Welcome to Oh, CRUD");
		System.out.println("--------------------------------");
		System.out.println(
				"Oh, CRUD allows you to create, read, update, and delete data in a database.\n");
		System.out.println("Controls:\n'c'-create 'r'-read 'u'-update 'd'-delete 'q'-quit");
		
		String choice;
		String[] tempName;
		int tempId;
		boolean quit = false;
		while(!quit) {
			System.out.println("\n--------------------------------");
			System.out.println("Type what you would like to do and press ENTER");
			choice = kb.nextLine();
			
			if (choice.equals("create") || choice.equals("c")) {
				System.out.println("What is the new name?");
				tempName = inputName();
				db.createEmployee(tempName[0], tempName[1]);

			} else if (choice.equals("update") || choice.equals("u")) {
				System.out.println("Which ID are you updating?");
				tempId = inputId();
				
				System.out.println("What is the updated name?");
				tempName = inputName();
				
				db.updateEmployee(tempId, tempName[0], tempName[1]);

			} else if (choice.equals("read") || choice.equals("r")) {
				readDb(db);
			} else if (choice.equals("delete") || choice.equals("d")) {
				db.deleteEmployee(inputId());
				
				System.out.println("Employee Deleted");
			} else if (choice.equals("quit") || choice.equals("q")) {
				quit = true;
			} else {
				System.out.println("Invalid input");
			}

		}
	}
	
	/**
	 * Sub menu for reading/selecting the DB. Allows for selecting by name, ID, or
	 * selecting all.
	 * @param db The EmployeeInterface which will perform operations
	 */
	private static void readDb(EmployeeInterface db) {
		String[] tempName;
		
		System.out.println("Type choice and hit ENTER");
		System.out.println("[1] Select all");
		System.out.println("[2] Select by name");
		System.out.println("[3] Select by ID\n");
		
		switch(kb.nextLine()) {
		case "1":
			for(Employee e : db.selectAllEmployee()) {
				System.out.println(e.toString());
			}
			break;
		case "2":
			tempName = inputName();
			System.out.println(db.selectEmployee(tempName[0], tempName[1]).toString());
			break;
		case "3":
			System.out.println(db.selectEmployee(inputId()).toString());
		}
	}
	
	/**
	 * Get user-provided credentials and uses them to call 
	 * {@link #createDS(String) createDS}
	 * @return The DataSource to be used by the interface
	 */
	private static DataSource login() {
		DataSource db = null;
		try {
			System.out.printf("Enter password for %s on %s\n", USER, DB_URL);
			String password = kb.nextLine();
			 db = createDS(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return db;
	}
	
	/**
	 * Create a new DataSource and sets metadata using password parameter and 
	 * class constants for user and URL.
	 * @param password Password for the SQL user instance
	 * @return The new DataSource with metadata set
	 */
	private static DataSource createDS(String password) {
		MysqlDataSource db = new MysqlDataSource();
		
		db.setURL(DB_URL);   
		db.setUser(USER);
		db.setPassword(password);
		
		return db;
	}

	/**
	 * Helper method to get name input from the user
	 * @return String[2] where element 0 is first name and element 1 is the last
	 */
	public static String[] inputName() {
		String[] fullName = new String[2];
		System.out.println("What is the employee's first name?");
		fullName[0] = kb.nextLine();
		System.out.println("What is the employee's last name?");
		fullName[1] = kb.nextLine();
		return fullName;
	}
	
	/**
	 * Helper method to get an integer representing an ID
	 * @return An integer representing an employee ID
	 */
	public static int inputId() {
		System.out.println("What is the employee's ID number?");
		int idNumber = kb.nextInt();
		kb.nextLine();
		return idNumber;

	}

}

