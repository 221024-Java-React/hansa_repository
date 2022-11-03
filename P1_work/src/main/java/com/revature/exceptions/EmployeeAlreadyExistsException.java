package com.revature.exceptions;

public class EmployeeAlreadyExistsException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public EmployeeAlreadyExistsException(){
		super("The employee is already registered");
	}

}
