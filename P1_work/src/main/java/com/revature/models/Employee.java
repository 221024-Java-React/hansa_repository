package com.revature.models;

import java.io.Serializable;
import java.util.Queue;
import java.util.LinkedList;

public class Employee {/*implements Serializable{
	private static final long serialVersionUID = 1L;*/
	
	private String firstName;
	private String lastName;
	private EmployeeType role;
	private String email;
	private String password;
	private LinkedList<Ticket> pendingTickets;
	private LinkedList<Ticket> processedTickets;
	
	public Employee() {
		super();
	}
	
	public Employee(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = EmployeeType.employee;
		this.email = email;
		this.password = password;
		Queue<Integer> pendingTickets = new LinkedList<>();
		LinkedList<Ticket> processedTickets = new LinkedList<>();
	}
	
	public Employee(String firstName, String lastName, EmployeeType role, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.email = email;
		this.password = password;
		Queue<Integer> pendingTickets = new LinkedList<>();
		LinkedList<Ticket> processedTickets = new LinkedList<>();
	}
	
	public void submitTicket(double amount, String description) {
		Ticket submission = new Ticket(amount,description);
		this.pendingTickets.add(submission);
	}
	
	public Ticket getTicket() {
		return pendingTickets.peek();
	}
	
	public LinkedList<Ticket> getAllTicket() {
		LinkedList<Ticket> allTickets = new LinkedList<>();
		allTickets.addAll(pendingTickets);
		allTickets.addAll(processedTickets);
		return allTickets;
	}
	
	public void updateTicket(TicketStatus status) {
		if(pendingTickets.size()<=0) {
			//might wanna set up a logback
			return;
		}
		Ticket updatedTicket = pendingTickets.getFirst();
		updatedTicket.setStatus(status);
		processedTickets.add(updatedTicket);
		pendingTickets.remove();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public EmployeeType isManager() {
		return role;
	}

	public void setManager(EmployeeType manager) {
		this.role = manager;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				//+ ", password=" + password + "]";
				+ "]";
	}
}
