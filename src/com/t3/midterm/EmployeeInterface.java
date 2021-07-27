package com.t3.midterm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EmployeeInterface {
	static DataSource db;
	
	public EmployeeInterface(DataSource db) {
		EmployeeInterface.db = db;
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
	
	public static List<Employee> selectAllEmployee() {
		List<Employee> empList = new ArrayList<Employee>();
		String query = String.format("SELECT * FROM employee");
		try (
				Connection c = db.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
			) {
			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				empList.add(new Employee(rs.getInt(1), 
										 rs.getString(2), 
										 rs.getString(3))
										);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return empList;
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
}
