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
	
	public void addTicket(Ticket t) {
		List<Ticket> pList = io.readObject();
		if(pList == null) {
			pList = new ArrayList<>();
		}
		
		pList.add(t);
		
		io.writeObject(pList);
	}
	public Ticket getTicket() {
		Ticket out = new Ticket();
		return out;
	}
	public List<Ticket> getAllTickets(){
		List<Ticket> pList = io.readObject();
		
		if(pList == null) {
			pList = new ArrayList<>();
		}
		
		return pList;
	}
	public List<Ticket> getEmployeeTickets(String email){
		List<Ticket> tickets = new LinkedList<>();
		return tickets;
	}
	public void updateTicket(Ticket p, String newString) {
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
	public List<Ticket> getTicketsByStatus(String email,String status){
		List<Ticket> tickets = new LinkedList<>();
		return tickets;
	}
}
