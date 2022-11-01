package com.revature.dao;

import java.util.List;

import com.revature.models.Ticket;

public interface TicketDao {
	public void addTicket(Ticket p);
	public List<Ticket> getAllTickets();
	//public void deleteTicket(String email);
	public void updateTicket(Ticket p);
}
