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
		updateEmployee();	
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
	
	public static void updateEmployee(Connection c) {
		 System.out.println("How many columns will you be updating?\n");
		 String numOfValues = kb.nextLine();
		 if (numOfValues == "3") {
			 System.out.println("Enter the new Employee id:\n");
			 String employeeId = kb.nextLine();
			 System.out.println("Enter the new first name\n ");
			 String firstName = kb.nextLine();
			 System.out.println("Enter the new last name\n");
			 String lastName = kb.nextLine();
			 System.out.println("Enter a row value where these new values are going.");
			 String whereValue = kb.nextLine();
			 System.out.println("Enter what column that value is in.");
			 String whereColumn = kb.nextLine();
			 String query = String.format("UPDATE sakila.actor SET employee_id = " + employeeId + ",  first_name = '" + firstName +"', last_name = '"+ lastName +"' WHERE " + whereColumn + " = " + whereValue);
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
			String set1 = kb.nextLine();
			System.out.println("Enter a column that the second value is going to (actor_id,first_name,last_name)");
			String set2 = kb.nextLine();
			System.out.println("Enter the first value");
			String value1 = kb.nextLine();
			System.out.println("Enter the second value");
			String value2 = kb.nextLine();
			System.out.println("Enter a row value where this is going");
			String whereValue = kb.nextLine();
			System.out.println("Enter what column that value is in");
			String whereColumn = kb.nextLine();
			if (set1.toLowerCase()=="actor_id") {
				if (whereColumn.toLowerCase()=="actor_id") {
					String query = String.format("UPDATE sakila.actor SET " + set1.toLowerCase() + " = " + value1 + ", " + set2.toLowerCase() + " = '" + value2 + "' WHERE " + whereColumn.toLowerCase() + " = " + whereValue);
					Statement statement;
					try {
						statement = c.createStatement();
						statement.execute(query);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				else {
					String query = String.format("UPDATE sakila.actor SET " + set1.toLowerCase() + " = " + value1 + ", " + set2.toLowerCase() + " = '" + value2 + "' WHERE " + whereColumn.toLowerCase() + " = '" + whereValue +"'");
					Statement statement;
					try {
						statement = c.createStatement();
						statement.execute(query);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		    }
			else if (set2.toLowerCase()=="actor_id") {
				if (whereColumn.toLowerCase()=="actor_id") {
					String query = String.format("UPDATE sakila.actor SET " + set1.toLowerCase() + " = " + value1 + ", " + set2.toLowerCase() + " = '" + value2 + "' WHERE " + whereColumn.toLowerCase() + " = " + whereValue);
					Statement statement;
					try {
						statement = c.createStatement();
						statement.execute(query);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				else {
					String query = String.format("UPDATE sakila.actor SET " + set1.toLowerCase() + " = " + value1 + ", " + set2.toLowerCase() + " = '" + value2 + "' WHERE " + whereColumn.toLowerCase() + " = '" + whereValue +"'");
					Statement statement;
					try {
						statement = c.createStatement();
						statement.execute(query);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			else {
				if (whereColumn.toLowerCase()=="actor_id") {
					String query = String.format("UPDATE sakila.actor SET " + set1.toLowerCase() + " = " + value1 + ", " + set2.toLowerCase() + " = '" + value2 + "' WHERE " + whereColumn.toLowerCase() + " = " + whereValue);
					Statement statement;
					try {
						statement = c.createStatement();
						statement.execute(query);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				else {
					String query = String.format("UPDATE sakila.actor SET " + set1.toLowerCase() + " = " + value1 + ", " + set2.toLowerCase() + " = '" + value2 + "' WHERE " + whereColumn.toLowerCase() + " = '" + whereValue +"'");
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
		 else if (numOfValues=="1") {
			 System.out.println("Enter the column that the value is going to (actor_id,first_name,last_name)");
			 String set = kb.nextLine();
			 System.out.println("Enter the value");
			 String value = kb.nextLine();
			 System.out.println("Enter a row value where this is going");
			 String whereValue = kb.nextLine();
			 System.out.println("Enter what column that value is in");
			 String whereColumn = kb.nextLine();
			 if (set.toLowerCase()=="actor_id") {
					String query = String.format("UPDATE sakila.actor SET " + set.toLowerCase() + " = " + value .toLowerCase() + " WHERE " + whereColumn.toLowerCase() + " = '" + whereValue +"' ");
					Statement statement;
					try {
						statement = c.createStatement();
						statement.execute(query);
					} catch (SQLException e) {
						e.printStackTrace();
					}
			  }   
			  else {
				  String query = String.format("UPDATE sakila.actor SET " + set.toLowerCase() + " = '" + value .toLowerCase() + "' WHERE " + whereColumn.toLowerCase() + " = '" + whereValue +"' ");
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
