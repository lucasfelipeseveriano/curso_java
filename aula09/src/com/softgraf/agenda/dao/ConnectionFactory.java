package com.softgraf.agenda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getMysqlConnection(MysqlDataSource ds) {
		Connection conection = null;	
		try {
			Class.forName(ds.getClasse());
			
			conection = DriverManager.getConnection(ds.getStringConexao(), ds.getUser(), ds.getPassword());
		}catch (ClassNotFoundException e) {
			System.out.println("Conector java/mysql não encontrado");
			e.printStackTrace();
			
		}catch (SQLException e) {
			System.out.println("Falha de conxão com o banco de dados");
			e.printStackTrace();
		}
		
		return conection;
		
	}

}
