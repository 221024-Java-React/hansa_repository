package com.revature.exceptions;

public class TicketDoesNotExistException extends RuntimeException{
	public TicketDoesNotExistException(){
		super("The ticket you are searching does not exist");
	}
}
