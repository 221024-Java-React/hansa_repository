package com.revature.models;

public class Ticket {
	
	enum posibility {
	    pending,
	    approved,
	    denied
	}
	private int amount;
	private String description;
	private posibility status;
	
	public Ticket(int amount, String description) {
		this.amount = amount;
		this.description = description;
		this.status = posibility.pending;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public posibility getStatus() {
		return status;
	}

	public void setStatus(posibility status) {
		this.status = status;
	}
}
