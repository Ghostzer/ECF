/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rlopez.IDE.dao;

/**
 *
 * @author rico
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectDB {

	
	public static Connection getConnection () {
		String url = "jdbc:mysql://localhost/dahouet";
		String login ="root";
		String passwd ="pouet";
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
				
		 
		}
		
		return cn;
	}
	
}
