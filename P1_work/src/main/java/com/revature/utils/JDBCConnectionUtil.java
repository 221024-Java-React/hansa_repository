package com.revature.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnectionUtil {
	
	
	/* Setup for a singleton to get an instance of this utility object */
	private static JDBCConnectionUtil util;
	
	private static Properties props = new Properties();
	
	private JDBCConnectionUtil() {}
	
	public static JDBCConnectionUtil getInstance() {
		if(util == null) {
			util = new JDBCConnectionUtil();
		}
		
		return util;
	}
	
	//We setup the actual logic to connect to the database
	public Connection getConnection() {
		
		Connection con = null;
		
		try {
			
			ClassLoader classLoader = getClass().getClassLoader();
			InputStream in = classLoader.getResourceAsStream("jdbc.properties");
			
			//If you didn't want to use a properties file and would rather use env
			//String url = System.getenv("DB_URL");
			
			String url="";
			String username="";
			String password="";
			
			props.load(in);
			
			url = props.getProperty("url");
			username = props.getProperty("username");
			password = props.getProperty("password");
			
			//Create a connection to our database
			con = DriverManager.getConnection(url, username, password);
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	

}