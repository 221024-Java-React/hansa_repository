package com.revature.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Ticket;
import com.revature.services.TicketService;

import io.javalin.http.Handler;

public class TicketController {
	private TicketService pServ;
	
	//Object mapper will be used to transform our java object from json and vise versa
	private ObjectMapper objectMapper;
	
	public TicketController(TicketService pServ) {
		this.pServ = pServ;
		objectMapper = new ObjectMapper();
	}
	
	public Handler handleRegister = (context) -> {
		
		//Inside is the logic for our controller for this register
		//When we register a person, we will send over information about that person in the body of the request
		//To get access to that body we use context.body()
		//To convert our body to a java object we will use the object mapper
		Ticket p = objectMapper.readValue(context.body(), Ticket.class);
		
		pServ.registerTicket(p);
		
		//Set our status code to OK
		context.status(201);
		context.result(objectMapper.writeValueAsString(p));
		
	};
	
	public Handler handleGetAll = (context) -> {
		List<Ticket> pList = pServ.getAllRegistered();
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(pList));
	};
}
