package com.t3.midterm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

/**
 *
 *
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
	 * Initializes the data source to connect
	 * @param db
	 */
	public EmployeeInterface(DataSource db) {
		EmployeeInterface.db = db;
	}

	/**
	 * Creates a new employee with given first and last name with an auto-
	 * incrementing id
	 * @param fName
	 * @param lName
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
	 * @param fName
	 * @param lName
	 * @return
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
	 * @param idNumber
	 * @return
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
	 * @return
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
	 * @param idNumber
	 * @param fName
	 * @param lName
	 */
	public void updateEmployee(int idNumber, String fName, String lName) {
		try (
				Connection c = db.getConnection();
				PreparedStatement ps = c.prepareStatement(UPDATE);
			) {
			ps.setString(1,fName);
			ps.setString(1,lName);
			ps.setInt(1, idNumber);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param toDeleteId
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
