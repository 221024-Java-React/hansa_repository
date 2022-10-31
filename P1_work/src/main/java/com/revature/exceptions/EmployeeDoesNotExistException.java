package com.revature.exceptions;

public class EmployeeDoesNotExistException extends RuntimeException{
	
	public EmployeeDoesNotExistException(){
		super("The user you are searching does not exist");
	}
}
