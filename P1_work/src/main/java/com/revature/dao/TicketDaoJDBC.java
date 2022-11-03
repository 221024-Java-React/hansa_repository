package com.revature.dao;
import com.revature.models.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.utils.JDBCConnectionUtil;

public class TicketDaoJDBC implements TicketDao {
	private JDBCConnectionUtil conUtil = JDBCConnectionUtil.getInstance();

	@Override
	public List<Course> readAllCourses() {
		
		List<Course> cList = new ArrayList();
		
		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM courses";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			ResultSet result = prepared.executeQuery();
			
			while(result.next()) {
				Course c = new Course();
				
				c.setCourseId(result.getInt(1));
				c.setSubject(result.getString(2));
				c.setCourseNumber(result.getInt(3));
				c.setCourseName(result.getString(4));
				
				if(result.getObject(5) == null) {
					c.setTeacher(null);
				} else {
					//Take the lazy route, and just store the teachers id
					Person t = new Person();
					t.setId(result.getInt(5));
					c.setTeacher(t);
				}
				
				cList.add(c);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		

		return cList;
	}

	@Override
	public void createCourse(Course c) {
		
		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "INSERT INTO courses(subject, course_number, name, teacher)"
					+ "VALUES (?,?,?,?)";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			//Now we need to set these parameters
			prepared.setString(1,  c.getSubject());
			prepared.setInt(2, c.getCourseNumber());
			prepared.setString(3, c.getCourseName());
			prepared.setNull(4, java.sql.Types.INTEGER);
			
			prepared.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteCourse(int id) {
		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "DELETE FROM courses WHERE course_id=?";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			prepared.setInt(1, id);
			
			prepared.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateCourse(Course c) {

		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "UPDATE courses SET subject = ?, course_number = ?, name=?, teacher=? WHERE course_id = ?";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			prepared.setString(1, c.getSubject());
			prepared.setInt(2, c.getCourseNumber());
			prepared.setString(3, c.getCourseName());
			
			if(c.getTeacher() == null) {
				prepared.setNull(4,  java.sql.Types.INTEGER);
			}else {
				 prepared.setInt(4, c.getTeacher().getId());
			}
			
			prepared.setInt(5, c.getCourseId());
			
			prepared.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
