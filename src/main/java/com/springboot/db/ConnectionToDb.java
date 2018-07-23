package com.springboot.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionToDb {
		
	public static Connection connect(){
		
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:TEST.db");
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		return conn;

	}   
}
