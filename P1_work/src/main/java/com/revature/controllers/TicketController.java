package com.revature.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.Ticket;
import com.revature.services.TicketService;

import io.javalin.http.Handler;

public class TicketController {
	private TicketService tServ;
	
	//Object mapper will be used to transform our java object from json and vise versa
	private ObjectMapper objectMapper;
	
	public TicketController(TicketService tServ) {
		this.tServ = tServ;
		objectMapper = new ObjectMapper();
	}
	
	public Handler handleRegister = (context) -> {
		Map<String, String> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		//Ticket t = objectMapper.readValue(context.body(), Ticket.class);
		Ticket t = new Ticket(Double.parseDouble(body.get("amount")), body.get("description"), 
				body.get("employee_email"));
		
		int out = tServ.addTicket(t,body.get("password"));
		if(out == 0) {
			context.status(400);
			context.result("Employee does not exist");
		}
		else if(out ==1){
			context.status(201);
			context.result(objectMapper.writeValueAsString(t));
		}
		else {
			
		}
	};
	
	public Handler handleGetAll = (context) -> {
		Map<String, String> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		List<Ticket> pList = tServ.getAllTickets(body.get("email"), body.get("password"));
		
		if(pList==null) {
			context.status(400);
			context.result("User failed login attempt");
		}
		else {
			context.status(200);
			context.result(objectMapper.writeValueAsString(pList));
		}
		
	};
	
	
	public Handler handleUpdate = (context) -> {
		/*Ticket t = objectMapper.readValue(context.body(), Ticket.class);
		String s = objectMapper.readValue(context.body(), String.class);*/
		
		Map<String, String> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		
		//tServ.updateTicket(t,s);
		//Employee loggedIn = pServ.login(body.get("email"), body.get("password"));
		//Ticket t = new Ticket(Integer.parseInt(body.get("id")));
		int out = tServ.updateTicket(body.get("email"), body.get("password"),
				Integer.parseInt(body.get("id")), body.get("status"));
		if(out==0) {
			context.status(400);
			context.result("User failed to login");
		}
		else if(out==1) {
			context.status(200);
			context.result("Ticket updated");
		}
		else if(out==2) {
			context.status(400);
			context.result("User is not a manager");
		}
		else if(out==3) {
			context.status(400);
			context.result("Ticket with ID does not exist");
		}
		
	};
	
	
	public Handler handleGetEmployeeTicket = (context) -> {
		//Ticket t = objectMapper.readValue(context.body(), Ticket.class);
		Map<String, String> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		List<Ticket> pList = tServ.getEmployeeTickets(body.get("email"), body.get("password"));
		if(pList==null) {
			context.status(400);
			context.result("User failed login attempt");
		}
		else {
			context.status(200);
			context.result(objectMapper.writeValueAsString(pList));
		}
		
	};
	
	public Handler handleGetByStatus = (context) -> {
		//Ticket t = objectMapper.readValue(context.body(), Ticket.class);
		Map<String, String> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		List<Ticket> pList = tServ.getTicketsByStatus(body.get("email"), body.get("password"),body.get("status"));
		
		if(pList==null) {
			context.status(400);
			context.result("User failed login attempt");
		}
		else {
			context.status(200);
			context.result(objectMapper.writeValueAsString(pList));
		}
	};
}
