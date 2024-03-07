package testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestesConexao {
	
	final private static String DRIVER = "com.mysql.cj.jdbc.Driver"; 
	final private static String DATABASE = "agenda";
	final private static String URL = "localhost:3306";
	final private static String STRCONEXAO = "jdbc:mysql://" + URL + "/" + DATABASE;
	final private static String USER = "root";
	final private static String PASSWORD = "softgraf";
	
	public static void main(String[]args) {
		
		try {
			
			Class.forName(DRIVER);
			System.out.println("Encontrou o driver de conxão");
			
			Connection conexao = DriverManager.getConnection(STRCONEXAO, USER, PASSWORD);
			System.out.println("Abriu a conexão");
			
			conexao.close();
			System.out.println("Fechou a conexão");
			
		} catch (SQLException e) {
			System.out.println("Conector java/mysql não encontrado");
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			System.out.println("Falha de conexão com o banco");
			e.printStackTrace();
		}
		
	}

}
