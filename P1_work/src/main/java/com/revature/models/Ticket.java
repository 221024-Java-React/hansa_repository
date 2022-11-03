package com.revature.models;

public class Ticket {
	private double amount;
	private String description;
	private TicketStatus status;
	
	public Ticket(double amount, String description) {
		this.amount = amount;
		this.description = description;
		this.status = TicketStatus.pending;
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
	}
	
	public String toString() {
		return "Ticket [amount=" + amount + ", description=" + description + ", status=" + getStatusString()
				//+ ", password=" + password + "]";
				+ "]";
	}
}
