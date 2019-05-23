package com.adaming.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDB {
	private static final String url= "jdbc:mysql://localhost:3306/bibliotheque";
	private static final String user="root";
	private static final String password="";
	
	//Etablir connection en créant un objet connection java.sql
	private static Connection con;
	
	
	
	//constructeur
	public ConnectionDB() throws ClassNotFoundException {

			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	//methode pour vérifier qu'il n'y a qu'une seule connection ouverte
	public static Connection getconnection() throws ClassNotFoundException {
		if(con==null) {
			new ConnectionDB();
			System.out.println("Ouverture d'une nouvelle session");
			return con;
		}else {
			System.out.println("Connection already exist");
			return con;
		}
	}
	
	//méthodes
	public static void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
