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
			 System.out.println("Enter the column name that value is in.");
			 String where = kb.next();
			 String whereColumn = where.toLowerCase();
			 if (whereColumn.equals("emp_id") || whereColumn.equals("empid") ) {	
			 	String query = String.format("UPDATE midterm employee SET EMP_ID = " + employeeId + ",  FIRSTNAME = '" + firstName +"', LASTNAME = '"+ lastName +"' WHERE " + whereColumn + " = " + whereValue);
			 	Statement statement;
			 		try {
			 			statement = c.createStatement();
			 			statement.execute(query);
			 		} catch (SQLException e) {
			 			e.printStackTrace();
			 		}
			 }
			 else if (whereColumn.equals("firstname") || whereColumn.equals("lastname") || whereColumn.equals("first name")|| whereColumn.equals("last name")){
				 String uery = String.format("UPDATE midterm employee SET EMP_ID= " + employeeId + ",  FIRSTNAME = '" + firstName +"', last_name = '"+ lastName +"' WHERE " + whereColumn + " = '" + whereValue +"'");
					Statement tatement;
						try {
							tatement = c.createStatement();
							tatement.execute(uery);
						} catch (SQLException e) {
							e.printStackTrace();
						}		
			 }
			 else {
				 System.out.println("That column name is not in the table. Try again.");
			 }
			 scanner.close();	
			 break;
		 case "2":
			System.out.println("Enter a column name that the first value is going to (EMP_ID, FIRSTNAME, LASTNAME)");
			String set1 = kb.next();
			System.out.println("Enter a column name that the second value is going to (EMP_ID, FIRSTNAME, LASTNAME)");
			String set2 = kb.next();
			System.out.println("Enter the first value");
			String value1 = kb.next();
			System.out.println("Enter the second value");
			String value2 = kb.next();
			System.out.println("Enter a row value where this will be going");
			String wherealue = kb.next();
			System.out.println("Enter the column name that value is in");
			String whereolumn = kb.next();
			if (set1.equals("EMP_ID") || set1.equals("emp_id")) {
				if (whereolumn.equals("EMP_ID") || whereolumn.equals("emp_id")) {
					String qery = String.format("UPDATE midterm employee SET " + set1.toUpperCase() + " = " + value1 + ", " + set2.toUpperCase() + " = '" + value2 + "' WHERE " + whereolumn.toUpperCase() + " = " + wherealue);
					 Statement statemen;
						try {
							statemen = c.createStatement();
							statemen.execute(qery);
						} catch (SQLException e) {
							e.printStackTrace();
						}
				}
				else if (whereolumn.equals("FIRSTNAME") ||  whereolumn.equals("LASTNAME")){
					String uery = String.format("UPDATE midterm employee SET " + set1.toUpperCase() + " = " + value1 + ", " + set2.toUpperCase() + " = '" + value2 + "' WHERE " + whereolumn.toUpperCase() + " = '" + wherealue +"'");
					Statement tatement;
						try {
							tatement = c.createStatement();
							tatement.execute(uery);
						} catch (SQLException e) {
							e.printStackTrace();
						}
				}
				else {
					System.out.println("One or both of the column names you have entered is not in the table. Try again.");
				}
		    }
			else if (set2.equals("EMP_ID") || set2.equals("emp_id")) {
				if (whereolumn.equals("EMP_ID") || whereolumn.equals("emp_id")) {
					String qury = String.format("UPDATE midterm employee SET " + set1.toLowerCase() + " = " + value1 + ", " + set2.toLowerCase() + " = '" + value2 + "' WHERE " + whereolumn.toLowerCase() + " = " + wherealue);
					Statement atement;
					try {
						atement = c.createStatement();
						atement.execute(qury);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				else if (whereolumn.equals("FIRSTNAME") || whereolumn.equals("LASTNAME")){
					String quey = String.format("UPDATE midterm employee SET " + set1.toLowerCase() + " = " + value1 + ", " + set2.toLowerCase() + " = '" + value2 + "' WHERE " + whereolumn.toLowerCase() + " = '" + wherealue +"'");
					Statement satement;
					try {
						satement = c.createStatement();
						satement.execute(quey);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				else {
					System.out.println("Invalid where column.");
				}
			}
			else if (set1.equals("FIRSTNAME") || set2.equals("FIRSTNAME") || set1.equals("LASTNAME") || set2.equals("LASTNAME")){
				if (whereolumn.equals("EMP_ID") || whereolumn.equals("emp_id")) {
					String que = String.format("UPDATE midterm employee SET " + set1.toLowerCase() + " = " + value1 + ", " + set2.toLowerCase() + " = '" + value2 + "' WHERE " + whereolumn.toLowerCase() + " = " + wherealue);
					Statement atement;
					try {
						atement = c.createStatement();
						atement.execute(que);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				else {
					String uer = String.format("UPDATE midterm employee SET " + set1.toLowerCase() + " = " + value1 + ", " + set2.toLowerCase() + " = '" + value2 + "' WHERE " + whereolumn.toLowerCase() + " = '" + wherealue +"'");
					Statement ateent;
					try {
						ateent = c.createStatement();
						ateent.execute(uer);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}	
			}
			scanner.close();
			break;
		 case "1":
			 System.out.println("Enter the column name that the value is going to (EMP_ID, FIRSTNAME, LASTNAME)");
			 String set = kb.next();
			 System.out.println("Enter the value");
			 String value = kb.next();
			 System.out.println("Enter a row value where this is going");
			 String hereValue = kb.next();
			 System.out.println("Enter what column that value is in");
			 String hereColumn = kb.next();
			 if (set.equals("EMP_ID") || set.equals("emp_id")) {
				 String qur = String.format("UPDATE midterm employee SET " + set.toLowerCase() + " = " + value .toLowerCase() + " WHERE " + hereColumn.toLowerCase() + " = '" + hereValue +"' ");
				 Statement tateent;
					try {
						tateent = c.createStatement();
						tateent.execute(qur);
					} catch (SQLException e) {
						e.printStackTrace();
					}
			 }   
			  else if (set.equals("FIRSTNAME") || set.equals("LASTNAME")){
				  String ery = String.format("UPDATE midterm employee SET " + set.toLowerCase() + " = '" + value .toLowerCase() + "' WHERE " + hereColumn.toLowerCase() + " = '" + hereValue +"' ");
				  Statement tateen;
					try {
						tateen = c.createStatement();
						tateen.execute(ery);
					} catch (SQLException e) {
						e.printStackTrace();
					}
			  }
			 scanner.close();
			 break;

		 }
	}	

}
