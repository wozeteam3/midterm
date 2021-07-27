package com.t3.midterm;

/**
 * Abstraction representing an employee entry in the database
 */
public class Employee {
	int employeeId;
	String firstName;
	String lastName;
	
	/**
	 * Default constructor
	 */
	public Employee() {}
	
	/**
	 * Fully parameterized constructor
	 * @param id ID of employee
	 * @param fName First name of employee
	 * @param lName Last name of employee
	 */
	public Employee(int id, String fName, String lName) {
		this.employeeId = id;
		this.firstName = fName;
		this.lastName = lName;
	}

	/**
	 * Getter for attribute Employee.employeeId
	 * @return ID of employee
	 */
	public int getEmployeeId() {
		return this.employeeId;
	}

	/**
	 * Setter for attribute Employee.employeeId
	 * @param employeeId ID of employee
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Getter for attribute Employee.firstName
	 * @return First name of employee
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Setter for attribute Employee.firstName
	 * @param firstName First name of employee
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter for attribute Employee.lastName
	 * @return Last name of employee
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Setter for attribute Employee.lastName
	 * @param lastName Last name of employee
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Override the default toString with a formatted representation of the 
	 * attributes. Uses {@code String.format()} to pad the string so that multiple
	 * employees can be printed as a pseudo-table
	 * @return A string representing the information contained in the Employee
	 * object
	 */
	@Override
	public String toString() {
		try {
			return String.format("| %-10s | %-10s | Employee ID: %04d |", 
				this.lastName.toUpperCase(), this.firstName, this.employeeId);
		} catch(NullPointerException e) {
			return String.format("| %-10s | %-10s | Employee ID: %04d |", 
					this.lastName, this.firstName, this.employeeId);
		}
	}
}

