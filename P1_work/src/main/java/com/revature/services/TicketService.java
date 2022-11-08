package com.revature.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.revature.dao.TicketDao;
import com.revature.dao.EmployeeDao;
import com.revature.exceptions.EmployeeDoesNotExistException;
import com.revature.exceptions.TicketDoesNotExistException;
import com.revature.exceptions.TicketAlreadyUpdatedException;
import com.revature.models.Employee;
import com.revature.models.EmployeeType;
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
	
	public List<Ticket> getAllTickets(String email, String password) {
		Employee p = employeeDao.getEmployeeByEmail(email);
		List<Ticket> cList = ticketDao.getAllTickets();
		LinkedList<Ticket> empty = new LinkedList<>();
		
		if(p == null) {
			LoggingUtil.getLogger().warn("User with email " + email + " attempted to access all tickets unsuccessfully");
			
			return empty;
		}
		//System.out.println(p.getPassword());
		
		if(password.equals(p.getPassword()) && p.isManager()==EmployeeType.manager) {
			for(int i=0; i<cList.size(); i++) {
				Ticket c = cList.get(i);
				if(c.getEmployee() != null) {
					//c.setEmployee(employeeDao.getEmployeeByEmail(c.getEmployeeEmail()));
					c.setEmployee(c.getEmployee());
					cList.set(i, c);
				}
			}
			LoggingUtil.getLogger().info("User " + email + " accessed tickets successfully");
		}
		else if(p.isManager()!=EmployeeType.manager) {
			LoggingUtil.getLogger().info("User " + email + " is not a manager");
		}
		else {
			LoggingUtil.getLogger().info("User " + email + " attempted to access tickets with incorrect password");
			return empty;
		}
		
		return cList;
	}
	
	public void addTicket(Ticket t) {
		ticketDao.addTicket(t);
		LoggingUtil.getLogger().info("New ticket was created: " + t);
	}
	
	public List<Ticket> getEmployeeTickets(String email, String password){
		
		Employee p = employeeDao.getEmployeeByEmail(email);
		LinkedList<Ticket> empty = new LinkedList<>();
		
		if(p == null) {
			LoggingUtil.getLogger().warn("User with email " + email + " had a failed login attempt");
			return empty;
		}
		//System.out.println(p.getPassword());
		
		if(password.equals(p.getPassword())) {
			List<Ticket> cList = ticketDao.getEmployeeTickets(email);
			
			for(int i=0; i<cList.size(); i++) {
				Ticket c = cList.get(i);
				if(c.getEmployee() != null) {
					//c.setEmployee(employeeDao.getEmployeeByEmail(c.getEmployeeEmail()));
					c.setEmployee(c.getEmployee());
					cList.set(i, c);
				}
			}
			LoggingUtil.getLogger().info("User " + email + " tickets accessed by group successfully");
			return cList;
			
		}
		else {
			LoggingUtil.getLogger().info("User " + email + " attempted to access grouped tickets with incorrect password");
			return empty;
		}
	}
	
	public void updateTicket(String email, String password, int id, String s) {
		Employee p = employeeDao.getEmployeeByEmail(email);
		
		if(p == null) {
			LoggingUtil.getLogger().warn("User with email " + email + " had a failed login attempt");
			
			return;
		}
		//System.out.println(p.getPassword());
		
		if(password.equals(p.getPassword())&& p.isManager()==EmployeeType.manager) {
			Ticket t = new Ticket();
			t=ticketDao.getTicketById(id);
			ticketDao.updateTicket(t,s);
			LoggingUtil.getLogger().info("User " + email + " updated ticket successfully");
		}
		else if(p.isManager()!=EmployeeType.manager) {
			LoggingUtil.getLogger().info("User " + email + " is not a manager");
		}
		else {
			LoggingUtil.getLogger().info("User " + email + " attempted to update tickets with incorrect password");
		}
	}
	
	public List<Ticket> getTicketsByStatus(String email,String password,String status){
		List<Ticket> cList = ticketDao.getTicketsByStatus(email,status);
		LinkedList<Ticket> empty = new LinkedList<>();
		
		Employee p = employeeDao.getEmployeeByEmail(email);
		
		if(p == null) {
			LoggingUtil.getLogger().warn("User with email " + email + " had a failed login attempt");
			
			return empty;
		}
		//System.out.println(p.getPassword());
		
		if(password.equals(p.getPassword())) {
			for(int i=0; i<cList.size(); i++) {
				Ticket c = cList.get(i);
				if(c.getEmployee() != null) {
					//c.setEmployee(employeeDao.getEmployeeByEmail(c.getEmployeeEmail()));
					c.setEmployee(c.getEmployee());
					cList.set(i, c);
				}
			}
			LoggingUtil.getLogger().info("User " + email + " tickets accessed by group successfully");
		}
		else {
			LoggingUtil.getLogger().info("User " + email + " attempted to access grouped tickets with incorrect password");
			return empty;
		}
		
		return cList;
	}
}
