package com.t3.midterm;

public class Employee {
	int employeeId;
	String firstName;
	String LastName;
	
	public Employee() {}
	
	public Employee(int id, String fName, String lName) {
		this.employeeId = id;
		this.firstName = fName;
		this.LastName = lName;
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
		return this.LastName;
	}

	public void setLastName(String lastName) {
		this.LastName = lastName;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + this.employeeId + ", firstName=" + this.firstName + ", LastName="
				+ this.LastName + "]";
	}
}

