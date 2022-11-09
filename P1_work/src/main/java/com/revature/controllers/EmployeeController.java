package com.revature.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.http.Handler;


public class EmployeeController {
	private EmployeeService pServ;
	
	//Object mapper will be used to transform our java object from json and vise versa
	private ObjectMapper objectMapper;
	
	public EmployeeController(EmployeeService pServ) {
		this.pServ = pServ;
		objectMapper = new ObjectMapper();
	}
	
	public Handler handleRegister = (context) -> {
		
		//Inside is the logic for our controller for this register
		//When we register a person, we will send over information about that person in the body of the request
		//To get access to that body we use context.body()
		//To convert our body to a java object we will use the object mapper
		Employee p = objectMapper.readValue(context.body(), Employee.class);
		
		pServ.registerEmployee(p);
		
		//Set our status code to OK
		context.status(201);
		context.result(objectMapper.writeValueAsString(p));
		
	};
	
	public Handler handleGetAll = (context) -> {
		List<Employee> pList = pServ.getAllRegistered();
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(pList));
	};
	
	public Handler handleLogin = (context) -> {
		Map<String, String> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		
		//Employee loggedIn = pServ.login(body.get("email"));
		Employee loggedIn = pServ.login(body.get("email"), body.get("password"));
		
		context.status(200);
		if(loggedIn!=null) {
			context.result(loggedIn.getId() + " " + loggedIn.getEmail());
		}
		else {
			context.result("Username and/or password incorrect");
		}
		
	};
}
