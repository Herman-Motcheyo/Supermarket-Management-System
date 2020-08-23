package supermarketmanagement.java.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import supermarketmanagement.java.control.AlertBox;

/**
 *  we use this class to connect database
 *  cette classe est faite pour se connecter à la base
 *  
 * */
public class ConnectDatabase {
	
	private static String url = "jdbc:mysql://localhost:3306/supermarketmanagemenysystem?serverTimezone=UTC"; 
	private static String user = "root";
	private static String password = "heramn";
	
 /**
* Objectt of connection //OBject de connexion
*/
	private static Connection connect ;
	
	/*
	 *use to create instance of connextion if not exist and @return it
	 **/
	public static Connection getInstance() {
	      
		if (connect == null) {
			try {
				connect = DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
			AlertBox.display("ERROR", "Don't connect to database");
				e.printStackTrace();
			}
		}
		return connect;
	}
	
	
}
