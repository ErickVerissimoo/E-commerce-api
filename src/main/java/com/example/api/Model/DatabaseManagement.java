package com.example.api.Model;


import java.sql.Connection;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseManagement {
	private JdbcDataSource Source;
	private static DatabaseManagement data = null;
	private DatabaseManagement () {}
	public static DatabaseManagement getInstance() {
		if (data == null) {
			data = new DatabaseManagement();
			
		}
			return data;
		
	}
	public Connection dataSource() {
		try {
			Source = new JdbcDataSource();
		Source.setURL("jdbc:h2:mem:apiEcommerce");
		Source.setUser("");
		Source.setPassword("");
		
	
		
		return Source.getConnection();}
		catch(Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
