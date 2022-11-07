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
		
		//Inside is the logic for our controller for this register
		//When we register a person, we will send over information about that person in the body of the request
		//To get access to that body we use context.body()
		//To convert our body to a java object we will use the object mapper
		Ticket t = objectMapper.readValue(context.body(), Ticket.class);
		//Employee p = objectMapper.readValue(context.body(), Employee.class);
		
		tServ.addTicket(t);
		
		//Set our status code to OK
		context.status(201);
		context.result(objectMapper.writeValueAsString(t));
		
	};
	
	public Handler handleGetAll = (context) -> {
		List<Ticket> pList = tServ.getAllTickets();
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(pList));
	};
	
	
	public Handler handleUpdate = (context) -> {
		Ticket t = objectMapper.readValue(context.body(), Ticket.class);
		String s = objectMapper.readValue(context.body(), String.class);
		
		tServ.updateTicket(t,s);
		
		context.status(200);
		context.result("Ticket updated");
	};
	
	
	public Handler handleGetEmployeeTicket = (context) -> {
		Ticket t = objectMapper.readValue(context.body(), Ticket.class);
		List<Ticket> pList = tServ.getEmployeeTickets(t.getEmployee());
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(pList));
	};
	
	public Handler handleGetPrevious = (context) -> {
		Ticket t = objectMapper.readValue(context.body(), Ticket.class);
		List<Ticket> pList = tServ.getTicketsByStatus(t.getEmployee(),t.getStatusString());
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(pList));
	};
}
