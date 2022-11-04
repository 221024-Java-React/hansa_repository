package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.EmployeeDoesNotExistException;
import com.revature.models.Employee;

public class EmployeeDaoFile implements EmployeeDao {
	
	private FileIO<List<Employee>> io;
	
	public EmployeeDaoFile() {
		this.io = new FileIO<List<Employee>>("people.txt");
	}

	@Override
	public void addEmployee(Employee p) {
		
		List<Employee> pList = io.readObject();
		if(pList == null) {
			pList = new ArrayList<>();
		}
		
		pList.add(p);
		
		io.writeObject(pList);
		
	}

	@Override
	public List<Employee> getAllPeople() {
		List<Employee> pList = io.readObject();
		
		if(pList == null) {
			pList = new ArrayList<>();
		}
		
		return pList;
	}
	public List<Employee> getAllPeoplePassword() {
		List<Employee> pList = io.readObject();
		
		if(pList == null) {
			pList = new ArrayList<>();
		}
		
		return pList;
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		List<Employee> pList = io.readObject();
		
		if(pList == null) {
			pList = new ArrayList<>();
		}
		
		for(Employee p: pList) {
			if(p.getEmail().equals(email)) {
				return p;
			}
		}
		
		//Instead of returning null, throw a new exception
		throw new EmployeeDoesNotExistException();
	}

	@Override
	public void deleteEmployee(String email) {
		List<Employee> pList = io.readObject();
		
		if(pList == null) {
			pList = new ArrayList<>();
		}
		
		for(int i=0; i<pList.size(); i++) {
			if(pList.get(i).getEmail().equals(email)) {
				pList.remove(i);
				return;
			}
		}
		
		//Instead of returning null, throw a new exception
		throw new EmployeeDoesNotExistException();
		
	}

	@Override
	public void updateEmployee(Employee p) {
		List<Employee> pList = io.readObject();
		
		if(pList == null) {
			pList = new ArrayList<>();
		}
		
		for(int i=0; i<pList.size(); i++) {
			//We are assuming the email is the unique identifier
			if(pList.get(i).getEmail().equals(p.getEmail())) {
				pList.remove(i);
				pList.add(p);
				return;
			}
		}
		
		//Instead of returning null, throw a new exception
		throw new EmployeeDoesNotExistException();
	}
	
	public Employee getEmployeeById(int id) {
		Employee p = null;
		return p;
	}

}