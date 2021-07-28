package com.t3.midterm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

/**
 * The main interface between the driver/command line and the database. Must be
 * instantiated with a {@link javax.sql.DataSource DataSource}
 */
public class EmployeeInterface {
	static DataSource db;
	
	final String CREATE    = "INSERT INTO employee (FIRSTNAME, LASTNAME) VALUES (?,?)";
	final String READ_ID   = "SELECT * FROM employee WHERE EMP_ID = ?";
	final String READ_NAME = "SELECT * FROM employee WHERE FIRSTNAME = ? AND LASTNAME = ?";
	final String READ_ALL  = "SELECT * FROM employee";
	final String UPDATE    = "UPDATE employee  SET FIRSTNAME = ?, LASTNAME = ? WHERE EMP_ID = ?";
	final String DELETE    = "DELETE FROM employee WHERE EMP_ID = ?";
	
	/**
	 * Initialize the data source attribute that the program will interface with.
	 * @param db The DataSource to use
	 */
	public EmployeeInterface(DataSource db) {
		EmployeeInterface.db = db;
	}

	/**
	 * Creates a new employee with given first and last name with an auto-
	 * incrementing id
	 * @param fName New first name
	 * @param lName New last name
	 */
	public void createEmployee(String fName, String lName) {
		try (
				Connection c = db.getConnection();
				PreparedStatement ps = c.prepareStatement(CREATE);
			) {
			ps.setString(1, fName);
			ps.setString(2, lName);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Return employee object matching both first and last name. This does not 
	 * account for overlap of names so in the case of two rows having matching
	 * first and last names, it will return the one with the largest ID. Also
	 * note that, since the SQL {@code WHERE} keyword is used, it is only
	 * case sensitive if specified in the schema.
	 * @param fName First name of target
	 * @param lName Last name of target
	 * @return An {@link com.t3.midterm.Employee Employee} object matching the 
	 * name passed
	 */
	public Employee selectEmployee(String fName, String lName) {
		Employee returnedEmployee = null;
		try (
				Connection c = db.getConnection();
				PreparedStatement ps = c.prepareStatement(READ_NAME);
			) {
			ps.setString(1, fName);
			ps.setString(2, lName);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				returnedEmployee = new Employee(rs.getInt(1), 
 												rs.getString(2), 
 												rs.getString(3));		
			}
			return returnedEmployee;
		} catch (SQLException e) {
			e.printStackTrace();
			returnedEmployee = null;
			return returnedEmployee;
		}

	}

	/**
	 * Return employee object corresponding to the idNumber parameter.
	 * @param idNumber ID of target employee
	 * @return An {@link com.t3.midterm.Employee Employee} object matching the 
	 * ID passed
	 */
	public Employee selectEmployee(int idNumber) {
		Employee returnedEmployee = null;
		try (
				Connection c = db.getConnection();
				PreparedStatement ps = c.prepareStatement(READ_ID);
			) {
			ps.setInt(1, idNumber);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				returnedEmployee = new Employee(rs.getInt(1), 
						 						rs.getString(2), 
						 						rs.getString(3));		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return returnedEmployee;
	}
	
	/**
	 * Return a {@code List<Employee>} containing all employees in the DB.
	 * @return A {@code List<Employee>} containing all employees in the DB.
	 */
	public List<Employee> selectAllEmployee() {
		List<Employee> empList = new ArrayList<Employee>();
		try (
				Connection c = db.getConnection();
				PreparedStatement ps = c.prepareStatement(READ_ALL);
			) {
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				empList.add(new Employee(rs.getInt(1), 
										 rs.getString(2), 
										 rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return empList;
	}

	/**
	 * Given a first name and last name, update the names columns in the row
	 * corresponding to idNumber.
	 * @param idNumber ID of target employee
	 * @param fName New first name
	 * @param lName New last name
	 */
	public void updateEmployee(int idNumber, String fName, String lName) {
		try (
				Connection c = db.getConnection();
				PreparedStatement ps = c.prepareStatement(UPDATE);
			) {
			ps.setString(1,fName);
			ps.setString(2,lName);
			ps.setInt(3, idNumber);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Delete the row in the table corresponding to idNumber.
	 * @param toDeleteId ID of target employee
	 */
	public void deleteEmployee(int toDeleteId) {
		try (
				Connection c = db.getConnection();
				PreparedStatement ps = c.prepareStatement(DELETE);
			) {
			ps.setInt(1, toDeleteId);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
