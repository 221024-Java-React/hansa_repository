package com.revature.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.dao.TicketDao;
import com.revature.dao.EmployeeDao;
import com.revature.exceptions.EmployeeDoesNotExistException;
import com.revature.exceptions.TicketDoesNotExistException;
import com.revature.exceptions.TicketAlreadyUpdatedException;
import com.revature.models.Employee;
import com.revature.models.Ticket;
import com.revature.utils.LoggingUtil;

public class TicketService {
	private TicketDao ticketDao;
	private EmployeeDao employeeDao;
	
	//Dependency injection, more on this later, just know, it allows us to change components of the same "type"
	//easily
	
	public TicketService(TicketDao ticketDao, EmployeeDao employeeDao) {
		this.ticketDao = ticketDao;
		this.employeeDao = employeeDao;
	}
	
	public List<Ticket> getAllTickets() {
		
		List<Ticket> cList = ticketDao.getAllTickets();
		
		for(int i=0; i<cList.size(); i++) {
			Ticket c = cList.get(i);
			if(c.getEmployee() != null) {
				c.setEmployee(employeeDao.getEmployeeByEmail(c.getEmployeeEmail()));
				cList.set(i, c);
			}
		}
		
		return cList;
	}
	
	public void addTicket(Employee p, Ticket t) {
		ticketDao.addTicket(p, t);
		LoggingUtil.getLogger().info("New ticket was created: " + t);
	}
	
	public List<Ticket> getEmployeeTickets(String email){
		List<Ticket> cList = ticketDao.getEmployeeTickets(email);
		
		for(int i=0; i<cList.size(); i++) {
			Ticket c = cList.get(i);
			if(c.getEmployee() != null) {
				c.setEmployee(employeeDao.getEmployeeByEmail(c.getEmployeeEmail()));
				cList.set(i, c);
			}
		}
		
		return cList;
	}
	
	public void updateTicket(Ticket c) {
		ticketDao.updateTicket(c);
		LoggingUtil.getLogger().info("Ticket was updated: " + c);
	}

}
