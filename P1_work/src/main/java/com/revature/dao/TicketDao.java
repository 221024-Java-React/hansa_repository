package com.revature.dao;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Ticket;

public interface TicketDao {
	public void addTicket(Ticket p);
	public List<Ticket> getAllTickets();
	public List<Ticket> getEmployeeTickets(String email, String password);
	//public void processEmployeeTickets(String email, String password, String employee);
	public Ticket getTicket();
	public void updateTicket(String email, String password, String employee);
}
