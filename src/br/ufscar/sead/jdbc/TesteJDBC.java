package br.ufscar.sead.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TesteJDBC {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/sead_employee?useSSL=false" ;
		String user = "sead";
		String pass = "sead";
		
		try {
			
			System.out.println("Connecting to DB: " + url);
			
			Connection c = DriverManager.getConnection(url, user, pass);
			
			System.out.println("Connection successful");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}

}
