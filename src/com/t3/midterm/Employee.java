package com.t3.midterm;

public class Employee {
	int employeeId;
	String firstName;
	String lastName;
	
	public Employee() {
		
	}
	
	public Employee(int id, String fName, String lName) {
		this.employeeId = id;
		this.firstName = fName;
		this.lastName = lName;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
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

