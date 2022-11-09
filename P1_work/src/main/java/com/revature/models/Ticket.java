package com.revature.models;

public class Ticket {
	private int id;
	private double amount;
	private String description;
	private TicketStatus status;
	//private Employee employee_email;
	private String employee_email;
	
	public Ticket() {
		super();
	}
	
	//public Ticket(double amount, String description, Employee employee_email) {
	public Ticket(double amount, String description, String employee_email) {
		this.amount = amount;
		this.description = description;
		this.status = TicketStatus.pending;
		this.employee_email=employee_email;
	}
	
	//public Ticket(int id, double amount, String description, Employee employee_email) {
	public Ticket(int id, double amount, String description, String employee_email) {
		this.id=id;
		this.amount = amount;
		this.description = description;
		this.status = TicketStatus.pending;
		this.employee_email=employee_email;
	}
	
	public double getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public TicketStatus getStatus() {
		return status;
	}
	
	public String getEmployee() {
		return employee_email;
	}
	
	public void setEmployee(String employee_email) {
		this.employee_email = employee_email;
	}
	
	public String getStatusString() {
		if(status==TicketStatus.pending) {
			return "pending";
		}
		else if(status==TicketStatus.approved) {
			return "approved";
		}
		else if(status==TicketStatus.denied) {
			return "denied";
		}
		return "pending";
	}
	
	public void setStatus(TicketStatus status) {
		this.status = status;
	}
	
	public void setStatus(String status) {
		if(status.equals("approved")) {
			this.status = TicketStatus.approved;
		}
		else if(status.equals("denied")) {
			this.status = TicketStatus.denied;
		}
		else {
			this.status = TicketStatus.pending;
		}
	}
	
	public String toString() {
		//return "Ticket [email=" + employee_email.getEmail() + "amount=" + amount + ", description=" + description + ", status=" + getStatusString()
		return "Ticket [email=" + employee_email + "amount=" + amount + ", description=" + description + ", status=" + this.getStatusString()
				//+ ", password=" + password + "]";
				+ "]";
	}
}
