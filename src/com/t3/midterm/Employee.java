package com.t3.midterm;

public class Employee {
	int employeeId;
	String firstName;
	String lastName;
	
	/**
	 * 
	 */
	public Employee() {}
	
	/**
	 * @param id
	 * @param fName
	 * @param lName
	 */
	public Employee(int id, String fName, String lName) {
		this.employeeId = id;
		this.firstName = fName;
		this.lastName = lName;
	}

	/**
	 * @return
	 */
	public int getEmployeeId() {
		return this.employeeId;
	}

	/**
	 * @param employeeId
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 *
	 */
	@Override
	public String toString() {
		try {
			return String.format("| %-10s | %-10s | Employee ID: %d |", 
				this.lastName.toUpperCase(), this.firstName, this.employeeId);
		} catch(NullPointerException e) {
			return String.format("| %-10s | %-10s | Employee ID: %d |", 
					this.lastName, this.firstName, this.employeeId);
		}
	}
}

