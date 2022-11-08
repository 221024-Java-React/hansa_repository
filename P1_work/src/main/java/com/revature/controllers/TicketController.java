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
		Map<String, String> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		List<Ticket> pList = tServ.getAllTickets(body.get("email"), body.get("password"));
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(pList));
	};
	
	
	public Handler handleUpdate = (context) -> {
		/*Ticket t = objectMapper.readValue(context.body(), Ticket.class);
		String s = objectMapper.readValue(context.body(), String.class);*/
		
		Map<String, String> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		
		//tServ.updateTicket(t,s);
		//Employee loggedIn = pServ.login(body.get("email"), body.get("password"));
		//Ticket t = new Ticket(Integer.parseInt(body.get("id")));
		tServ.updateTicket(body.get("email"), body.get("password"),
				Integer.parseInt(body.get("id")), body.get("status"));
		
		context.status(200);
		context.result("Ticket updated");
	};
	
	
	public Handler handleGetEmployeeTicket = (context) -> {
		//Ticket t = objectMapper.readValue(context.body(), Ticket.class);
		Map<String, String> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		List<Ticket> pList = tServ.getEmployeeTickets(body.get("email"), body.get("password"));
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(pList));
	};
	
	public Handler handleGetByStatus = (context) -> {
		//Ticket t = objectMapper.readValue(context.body(), Ticket.class);
		Map<String, String> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		List<Ticket> pList = tServ.getTicketsByStatus(body.get("email"), body.get("password"),body.get("status"));
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(pList));
	};
}
