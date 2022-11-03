package com.revature.services;

import java.util.List;

import com.revature.dao.TicketDao;
import com.revature.exceptions.EmployeeDoesNotExistException;
import com.revature.exceptions.TicketDoesNotExistException;
import com.revature.models.Employee;
import com.revature.models.Ticket;
import com.revature.utils.LoggingUtil;

public class TicketService {
	private TicketDao ticketDao;
	
	//Dependency injection, more on this later, just know, it allows us to change components of the same "type"
	//easily
	
	public TicketService(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}
	
	public void registerTicket(Ticket p) {
		ticketDao.addTicket(p);
	
	}
	
	public Ticket getTicket() {
		
	}
	
	public void updateTicket(Ticket p, String update) {
		Ticket p = employeeDao.getTicket();
		
		if(p == null) {
			LoggingUtil.getLogger().warn("User with email " + email + " had a failed login attempt");
			
			return null;
		}
		//System.out.println(p.getPassword());
		
		if(password.equals(p.getPassword())) {
			LoggingUtil.getLogger().info("User " + email + " logged in successfully");
			return p;
		}
		else {
			LoggingUtil.getLogger().info("User " + email + " attempted to log in with incorrect password");
			//System.out.println(password);
			return null;
		}
		ticketDao.addTicket(p);
	
	}
}
