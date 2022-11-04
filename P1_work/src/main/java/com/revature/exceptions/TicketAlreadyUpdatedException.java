package com.revature.exceptions;

public class TicketAlreadyUpdatedException extends RuntimeException{
	public TicketAlreadyUpdatedException(){
		super("The ticket you are trying to update has already been updated");
	}
}