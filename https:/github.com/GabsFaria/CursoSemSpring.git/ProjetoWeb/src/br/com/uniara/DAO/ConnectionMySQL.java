package br.com.uniara.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
public static String status = "Não conectou...";
    
    public static Connection getConexaoMySQL() {

    	Connection connection = null;

		try {
			String driverName = "com.mysql.jdbc.Driver";                        
			Class.forName(driverName);
		  
			String serverName = "localhost";
			String mydatabase ="firstdb";
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			String username = "user";      
			String password = "pass1234";
			connection = DriverManager.getConnection(url, username, password);
			
			if (connection != null) {
				status = ("STATUS--->Conectado com sucesso!");
			} else {
			   	status = ("STATUS--->Não foi possivel realizar conexão");
		   	}
		
			return connection;
		} catch (ClassNotFoundException e) {  //Driver não encontrado
			System.out.println("O driver expecificado nao foi encontrado.");
			return null;
		} catch (SQLException e) {
			System.out.println("Nao foi possivel conectar ao Banco de Dados.");
			return null;
		}
	}
	
    public static String statusConection() {
    	return status;
	}
	
    public static boolean FecharConexao() {
    	try {
    		ConnectionMySQL.getConexaoMySQL().close();
	   		return true;
		} catch (SQLException e) {
		   return false;
		}
	}
	
    public static java.sql.Connection ReiniciarConexao() {
    	FecharConexao();
		return ConnectionMySQL.getConexaoMySQL();
	}
	

}
