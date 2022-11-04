package com.revature.dao;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDao {
	
	public void addEmployee(Employee p) throws Exception;
	public List<Employee> getAllPeople();
	public Employee getEmployeeByEmail(String email);
	public void deleteEmployee(String email);
	public void updateEmployee(Employee p);
	public Employee getEmployeeById(int id);
}