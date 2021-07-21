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
		String password = "password!";
		
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
		 Scanner scanner = new Scanner(System.in);
		 switch (scanner.next()) {
		 case "3":
			 System.out.println("Enter the new Employee id:\n");
			 String employeeId = kb.next();
			 System.out.println("Enter the new first name\n ");
			 String firstName = kb.next();
			 System.out.println("Enter the new last name\n");
			 String lastName = kb.next();
			 System.out.println("Enter a row value where these new values are going.");
			 String whereValue = kb.next();
			 System.out.println("Enter what column that value is in.");
			 String whereColumn = kb.next();
			 String query = String.format("UPDATE sakila.actor SET employee_id = " + employeeId + ",  first_name = '" + firstName +"', last_name = '"+ lastName +"' WHERE " + whereColumn + " = " + whereValue);
			 Statement statement;
				try {
					statement = c.createStatement();
					statement.execute(query);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 break;
		 case "2":
			System.out.println("Enter a column that the first value is going to (actor_id,first_name,last_name)");
			String set1 = kb.next();
			System.out.println("Enter a column that the second value is going to (actor_id,first_name,last_name)");
			String set2 = kb.next();
			System.out.println("Enter the first value");
			String value1 = kb.next();
			System.out.println("Enter the second value");
			String value2 = kb.next();
			System.out.println("Enter a row value where this is going");
			String wherealue = kb.next();
			System.out.println("Enter what column that value is in");
			String whereolumn = kb.next();
			if (set1.toLowerCase()=="actor_id") {
				if (whereolumn.toLowerCase()=="actor_id") {
					String qery = String.format("UPDATE sakila.actor SET " + set1.toLowerCase() + " = " + value1 + ", " + set2.toLowerCase() + " = '" + value2 + "' WHERE " + whereolumn.toLowerCase() + " = " + wherealue);
					 Statement statemen;
						try {
							statemen = c.createStatement();
							statemen.execute(qery);
						} catch (SQLException e) {
							e.printStackTrace();
						}
				}
				else {
					String uery = String.format("UPDATE sakila.actor SET " + set1.toLowerCase() + " = " + value1 + ", " + set2.toLowerCase() + " = '" + value2 + "' WHERE " + whereolumn.toLowerCase() + " = '" + wherealue +"'");
					Statement tatement;
						try {
							tatement = c.createStatement();
							tatement.execute(uery);
						} catch (SQLException e) {
							e.printStackTrace();
						}
				}
		    }
			else if (set2.toLowerCase()=="actor_id") {
				if (whereolumn.toLowerCase()=="actor_id") {
					String qury = String.format("UPDATE sakila.actor SET " + set1.toLowerCase() + " = " + value1 + ", " + set2.toLowerCase() + " = '" + value2 + "' WHERE " + whereolumn.toLowerCase() + " = " + wherealue);
					Statement atement;
					try {
						atement = c.createStatement();
						atement.execute(qury);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				else {
					String quey = String.format("UPDATE sakila.actor SET " + set1.toLowerCase() + " = " + value1 + ", " + set2.toLowerCase() + " = '" + value2 + "' WHERE " + whereolumn.toLowerCase() + " = '" + wherealue +"'");
					Statement satement;
					try {
						satement = c.createStatement();
						satement.execute(quey);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			else {
				if (whereolumn.toLowerCase()=="actor_id") {
					String que = String.format("UPDATE sakila.actor SET " + set1.toLowerCase() + " = " + value1 + ", " + set2.toLowerCase() + " = '" + value2 + "' WHERE " + whereolumn.toLowerCase() + " = " + wherealue);
					Statement atement;
					try {
						atement = c.createStatement();
						atement.execute(que);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				else {
					String uer = String.format("UPDATE sakila.actor SET " + set1.toLowerCase() + " = " + value1 + ", " + set2.toLowerCase() + " = '" + value2 + "' WHERE " + whereolumn.toLowerCase() + " = '" + wherealue +"'");
					Statement ateent;
					try {
						ateent = c.createStatement();
						ateent.execute(uer);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			break;
		 case "1":
			 System.out.println("Enter the column that the value is going to (actor_id,first_name,last_name)");
			 String set = kb.next();
			 System.out.println("Enter the value");
			 String value = kb.next();
			 System.out.println("Enter a row value where this is going");
			 String hereValue = kb.next();
			 System.out.println("Enter what column that value is in");
			 String hereColumn = kb.next();
			 if (set.toLowerCase()=="actor_id") {
				 String qur = String.format("UPDATE sakila.actor SET " + set.toLowerCase() + " = " + value .toLowerCase() + " WHERE " + hereColumn.toLowerCase() + " = '" + hereValue +"' ");
				 Statement tateent;
					try {
						tateent = c.createStatement();
						tateent.execute(qur);
					} catch (SQLException e) {
						e.printStackTrace();
					}
			 }   
			  else {
				  String ery = String.format("UPDATE sakila.actor SET " + set.toLowerCase() + " = '" + value .toLowerCase() + "' WHERE " + hereColumn.toLowerCase() + " = '" + hereValue +"' ");
				  Statement tateen;
					try {
						tateen = c.createStatement();
						tateen.execute(ery);
					} catch (SQLException e) {
						e.printStackTrace();
					}
			  }
			 break;

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
