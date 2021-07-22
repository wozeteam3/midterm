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
			 String set01 = kb.next();
			 System.out.println("Enter the value");
			 String value = kb.next();
			 System.out.println("Enter a row value where this is going");
			 String hereValue = kb.next();
			 System.out.println("Enter what column that value is in");
			 String hereColumn = kb.next();
       String set = set01.toLowerCase();
			 if (set.equals("empdid") || set.equals("emp_id")) {
				 String qur = String.format("UPDATE midterm employee SET " + set.toLowerCase() + " = " + value .toLowerCase() + " WHERE " + hereColumn.toLowerCase() + " = '" + hereValue +"' ");
				 Statement tateent;
					try {
						tateent = c.createStatement();
						tateent.execute(qur);
					} catch (SQLException e) {
						e.printStackTrace();
					}
			 }   
			  else if (set.equals("firstname") || set.equals("lastname") || set.equals("last name") || set.equals("first name")){
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

}
