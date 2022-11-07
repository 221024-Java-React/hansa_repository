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
	
	public void addTicket(Ticket t) {
		try {
			
			Connection connection = conUtil.getConnection();
			
			//int type = t.getStatus().ordinal() + 1;
			//String status=t.getStatusString();
			
			String sql = "INSERT INTO ticket(amount, description, employee_email, status)"
					+ "VALUES (?,?,?,?)";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			//Now we need to set these parameters
			prepared.setDouble(1, t.getAmount());
			prepared.setString(2, t.getDescription());
			prepared.setString(3, t.getEmployee());
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
				
				t.setId(result.getInt(1));
				if(result.getString(2) == null) {
					t.setEmployee(null);
				} else {
					//Take the lazy route, and just store the teachers id
					//Employee p = new Employee();
					//t.setEmployee(result.getString(1));
					t.setEmployee(result.getString(2));
				}
				t.setDescription(result.getString(3));
				t.setAmount(result.getDouble(4));
				t.setStatus(result.getString(5));
				
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
			
			String sql = "SELECT * FROM ticket where employee_email = ?";
			
			/*
			 String sql = "INSERT INTO ticket(employee_email,description,amount,status)"
					+ "VALUES (?,?,?,?)";
			 */
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			prepared.setString(1, email);
			
			ResultSet result = prepared.executeQuery();
			
			while(result.next()) {
				Ticket t = new Ticket();
				
				t.setId(result.getInt(1));
				if(result.getObject(2) == null) {
					t.setEmployee(null);
				} else {
					//Take the lazy route, and just store the teachers id
					//Employee p = new Employee();
					//t.setEmployee(result.getString(1));
					t.setEmployee(result.getString(2));
				}
				t.setDescription(result.getString(3));
				t.setAmount(result.getDouble(4));
				t.setStatus(result.getString(5));
				
				cList.add(t);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		

		return cList;
	}
	
	public void updateTicket(Ticket t, String newStatus) {
		try {
			
			Connection connection = conUtil.getConnection();
			
			/*
			 String sql = "INSERT INTO ticket(employee_email,description,amount,status)"
					+ "VALUES (?,?,?,?)";
			 */
			
			String sql = "UPDATE ticket SET status=? "
					+ "WHERE ticketid = ? and status = ?";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			/*prepared.setString(1, t.getEmployee());
			prepared.setString(2, t.getDescription());
			prepared.setDouble(3, t.getAmount());*/
			prepared.setString(1, t.getStatusString());
			/*prepared.setString(5, t.getEmployee());
			prepared.setString(6, t.getDescription());
			prepared.setDouble(7, t.getAmount());*/
			prepared.setDouble(2, t.getId());
			prepared.setString(3, "pending");
			
			
			prepared.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Ticket> getTicketsByStatus(String email,String status){
		List<Ticket> cList = new ArrayList();
		
		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM ticket where employee_email = ? and status = ?";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			prepared.setString(1, email);
			prepared.setString(2, status);
			
			ResultSet result = prepared.executeQuery();
			
			while(result.next()) {
				Ticket t = new Ticket();
				
				t.setId(result.getInt(1));
				if(result.getObject(2) == null) {
					t.setEmployee(null);
				} else {
					//Take the lazy route, and just store the teachers id
					//Employee p = new Employee();
					//t.setEmployee(result.getString(1));
					t.setEmployee(result.getString(2));
				}
				t.setDescription(result.getString(3));
				t.setAmount(result.getDouble(4));
				t.setStatus(result.getString(5));
				
				cList.add(t);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		

		return cList;
	}
}
