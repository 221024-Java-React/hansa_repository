package com.revature.services;

import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.exceptions.EmployeeAlreadyExistsException;
import com.revature.exceptions.EmployeeDoesNotExistException;
import com.revature.models.Employee;
import com.revature.utils.LoggingUtil;

public class EmployeeService {
	private EmployeeDao employeeDao;
	
	//Dependency injection, more on this later, just know, it allows us to change components of the same "type"
	//easily
	
	public EmployeeService(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public void registerEmployee(Employee p) {
		/*
		try {
			employeeDao.getEmployeeByEmail(p.getEmail());
			//Throw an exception if the user exists when trying to register
			LoggingUtil.getLogger().warn("User with email " + p.getEmail() + " tried registering again");
		} catch (EmployeeDoesNotExistException e) {
			employeeDao.addEmployee(p);
			LoggingUtil.getLogger().info("New user registed");
		}
		*/
		try {
			employeeDao.addEmployee(p);
			LoggingUtil.getLogger().warn("User: " + p + " was registered");
		} catch(Exception e) {
			LoggingUtil.getLogger().warn("User with email " + p.getEmail() + " tried to register a second time");
			throw new EmployeeAlreadyExistsException();
		}
	}
	
	public Employee login(String email, String password) {
		Employee p = employeeDao.getEmployeeByEmail(email);
		
		if(p == null) {
			LoggingUtil.getLogger().warn("User with email " + email + " had a failed login attempt");
			
			return null;
		}
		//System.out.println(p.getPassword());
		
		if(password.equals(p.getPassword())) {
			LoggingUtil.getLogger().info("User " + email + " logged in successfully");
			return p;
		}
		else {
			LoggingUtil.getLogger().info("User " + email + " attempted to log in with incorrect password");
			//System.out.println(password);
			return null;
		}
	}
	
	/*public Employee login(String email) {
		Employee p = employeeDao.getEmployeeByEmail(email);
		
		if(p == null) {
			LoggingUtil.getLogger().warn("User with email " + email + " had a failed login attempt");
			
			return null;
		}
		
		
		LoggingUtil.getLogger().info("User " + email + " logged in");
		return p;
	}*/
	
	public List<Employee> getAllRegistered(){
		return employeeDao.getAllPeople();
	}
}
