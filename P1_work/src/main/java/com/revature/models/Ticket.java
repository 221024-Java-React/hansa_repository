package com.revature.models;

public class Ticket {
	private int amount;
	private String description;
	private boolean status;
	
	public Ticket(int amount, String description, boolean status) {
		this.amount = amount;
		this.description = description;
		this.status = status;
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
	
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
