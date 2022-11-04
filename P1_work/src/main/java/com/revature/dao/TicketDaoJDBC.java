package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Ticket;
import com.revature.models.Employee;
import com.revature.utils.JDBCConnectionUtil;

public class TicketDaoJDBC implements TicketDao {
	private JDBCConnectionUtil conUtil = JDBCConnectionUtil.getInstance();
	
	public void addTicket(Employee p, Ticket t) {
			try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "INSERT INTO ticket(employee_email,description,amount,status)"
					+ "VALUES (?,?,?,?)";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			//Now we need to set these parameters
			prepared.setString(1, p.getEmail());
			prepared.setString(2, t.getDescription());
			prepared.setDouble(3, t.getAmount());
			prepared.setString(4, t.getStatusString());
			
			prepared.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Ticket> getAllTickets(){
		List<Ticket> cList = new ArrayList();
		
		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM ticket";
			
			/*
			 String sql = "INSERT INTO ticket(employee_email,description,amount,status)"
					+ "VALUES (?,?,?,?)";
			 */
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			ResultSet result = prepared.executeQuery();
			
			while(result.next()) {
				Ticket t = new Ticket();
				
				if(result.getObject(1) == null) {
					t.setEmployee(null);
				} else {
					//Take the lazy route, and just store the teachers id
					Employee p = new Employee();
					p.setEmail(result.getString(1));
					t.setEmployee(p);
				}
				t.setDescription(result.getString(2));
				t.setAmount(result.getDouble(3));
				t.setStatus(result.getString(4));
				
				cList.add(t);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		

		return cList;
	}
	
	public List<Ticket> getEmployeeTickets(String email){
		List<Ticket> cList = new ArrayList();
		
		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM ticket where employee_email = " + email + "'";
			
			/*
			 String sql = "INSERT INTO ticket(employee_email,description,amount,status)"
					+ "VALUES (?,?,?,?)";
			 */
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			ResultSet result = prepared.executeQuery();
			
			while(result.next()) {
				Ticket t = new Ticket();
				
				if(result.getObject(1) == null) {
					t.setEmployee(null);
				} else {
					//Take the lazy route, and just store the teachers id
					Employee p = new Employee();
					p.setEmail(result.getString(1));
					t.setEmployee(p);
				}
				t.setDescription(result.getString(2));
				t.setAmount(result.getDouble(3));
				t.setStatus(result.getString(4));
				
				cList.add(t);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		

		return cList;
	}
	
	public void updateTicket(Ticket t) {
		try {
			
			Connection connection = conUtil.getConnection();
			
			/*
			 String sql = "INSERT INTO ticket(employee_email,description,amount,status)"
					+ "VALUES (?,?,?,?)";
			 */
			
			String sql = "UPDATE ticket SET employee_email = ?, description = ?, amount=?, status=? "
					+ "WHERE employee_email = ? and description = ? and amount=?";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			prepared.setString(1, t.getEmployeeEmail());
			prepared.setString(2, t.getDescription());
			prepared.setDouble(3, t.getAmount());
			prepared.setString(4, t.getStatusString());
			prepared.setString(5, t.getEmployeeEmail());
			prepared.setString(6, t.getDescription());
			prepared.setDouble(7, t.getAmount());
			
			
			prepared.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
