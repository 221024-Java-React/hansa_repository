package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.EmployeeType;
import com.revature.models.Ticket;
import com.revature.utils.JDBCConnectionUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoJDBC implements EmployeeDao{
	
	private JDBCConnectionUtil conUtil = JDBCConnectionUtil.getInstance();

	@Override
	public void addEmployee(Employee p) throws SQLException{

		//We need a connection to create a statment
		Connection connection = conUtil.getConnection();
			
		int type = p.isManager().ordinal() + 1;
			
		//The actual SQL query we want to execute
		String sql = "INSERT INTO employee (type, first_name, last_name, email, password) VALUES"
				+ "(" + type + ",'" + p.getFirstName() +"','" + p.getLastName() + "','" +
				p.getEmail() + "','" + p.getPassword() + "')";
		
		//Get the statement to actually make our query
		Statement statement = connection.createStatement();
			
		//Execute the SQL query
		statement.execute(sql);
	}

	@Override
	public List<Employee> getAllPeople() {
		
		List<Employee> pList = new ArrayList();

		try {
			
			//We need a connection to create a statment
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM employee order by employeeID";
			
			Statement statement = connection.createStatement();
			
			//When we are returning data from a query, we need to store that data in a ResultSet
			//ResultSet will essentially return a collection of rows with your data
			ResultSet result = statement.executeQuery(sql);
			
			//We need to loop through our result set and return the list of employee
			while(result.next()) {
				Employee p = new Employee();
				//JDBC indexes from 1
				p.setId(result.getInt(1));
				
				if(result.getInt(2) == 2) {
					p.setManager(EmployeeType.manager);
				}else {
					p.setManager(EmployeeType.employee);
				}
				
				p.setFirstName(result.getString(3));
				p.setLastName(result.getString(4));
				p.setEmail(result.getString(5));
				p.setPassword(result.getString(6));
				
				pList.add(p);
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return pList;
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		Employee p = null;
		
		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM employee WHERE email='" + email + "'";
			
			Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				p = new Employee();
				p.setId(result.getInt(1));
				
				if(result.getInt(2) == 2) {
					p.setManager(EmployeeType.manager);
				}else {
					p.setManager(EmployeeType.employee);
				}
				
				p.setFirstName(result.getString(3));
				p.setLastName(result.getString(4));
				p.setEmail(result.getString(5));
				p.setPassword(result.getString(6));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public void deleteEmployee(String email) {

		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "DELETE FROM employee WHERE email='" + email + "'";
			
			Statement statement = connection.createStatement();
			
			statement.execute(sql);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateEmployee(Employee p) {

		try {
			
			Connection connection = conUtil.getConnection();
			
			int type = p.isManager().ordinal() + 1;
			
			String sql = "UPDATE employee SET type ="  + type + ",first_name = '" + p.getFirstName() + 
					"', last_name ='" + p.getLastName() + "', email='" + p.getEmail() + "', password='" +
					p.getPassword() + "' WHERE id =" + p.getId();
			
			Statement statement = connection.createStatement();
			
			statement.execute(sql);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		Employee p = null;

		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM employee WHERE id=?";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			prepared.setInt(1, id);
			
			ResultSet result = prepared.executeQuery();
			
			while(result.next()) {
				p = new Employee();
				p.setId(result.getInt(1));
				
				if(result.getInt(2) == 2) {
					p.setManager(EmployeeType.manager);
				}else {
					p.setManager(EmployeeType.employee);
				}
				
				p.setFirstName(result.getString(3));
				p.setLastName(result.getString(4));
				p.setEmail(result.getString(5));
				p.setPassword(result.getString(6));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return p;
	}
}
