package tests;

import java.sql.DriverManager;

import java.sql.Connection;

public class DatabaseConnection {

	public static void main(String[] args){
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/bank_application?useSSL=false";
		String user = "admin";
		String pass = "admin";	
		
		try{
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = 
					DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Git");
			
			
		}catch(Exception exc){
			exc.printStackTrace();
		}
	}
}
