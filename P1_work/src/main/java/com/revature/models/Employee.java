package com.revature.models;

import java.io.Serializable;

public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private boolean manager;
	private String email;
	private String password;
	
	public Employee() {
		super();
	}
	
	public Employee(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.manager = false;
		this.email = email;
		this.password = password;
	}
	
	public Employee(String firstName, String lastName, boolean manager, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.manager = manager;
		this.email = email;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isManager() {
		return manager;
	}

	public void setFaculty(boolean manager) {
		this.manager = manager;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				//+ ", password=" + password + "]";
				+ "]";
	}
}
