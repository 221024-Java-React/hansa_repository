package com.revature.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.exceptions.EmployeeDoesNotExistException;
import com.revature.exceptions.TicketDoesNotExistException;
import com.revature.models.Ticket;

public class TicketDaoFile implements TicketDao{
	
	private FileIO<List<Ticket>> io;
	
	public TicketDaoFile() {
		this.io = new FileIO<List<Ticket>>("ticket.txt");
	}
	
	public void addTicket(Ticket p) {
		List<Ticket> pList = io.readObject();
		if(pList == null) {
			pList = new ArrayList<>();
		}
		
		pList.add(p);
		
		io.writeObject(pList);
	}
	public Ticket getTicket() {
		Ticket out = new Ticket(0.00,"ouch");
		return out;
	}
	public List<Ticket> getAllTickets(){
		List<Ticket> pList = io.readObject();
		
		if(pList == null) {
			pList = new ArrayList<>();
		}
		
		return pList;
	}
	public List<Ticket> getEmployeeTickets(String email, String password){
		List<Ticket> tickets = new LinkedList<>();
		return tickets;
	}
	public void updateTicket(Ticket p) {
		List<Ticket> pList = io.readObject();
		
		if(pList == null) {
			pList = new ArrayList<>();
		}
		
		for(int i=0; i<pList.size(); i++) {
			if(pList.get(i).equals(p)) {
				pList.remove(i);
				pList.add(p);
				return;
			}
		}
		
		//Instead of returning null, throw a new exception
		throw new TicketDoesNotExistException();
	}
	
	public void updateTicket(String email, String password, String employee) {
		return;
	}
}
