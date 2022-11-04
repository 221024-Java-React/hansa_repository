package com.revature.dao;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Ticket;

public interface TicketDao {
	public void addTicket(Employee p, Ticket t);
	public List<Ticket> getAllTickets();
	public List<Ticket> getEmployeeTickets(String email);
	//public void processEmployeeTickets(String email, String password, String employee);
	//public Ticket getTicket();
	public void updateTicket(Ticket t);
}
