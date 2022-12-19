package conexaoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
/*Classe de conexão com o Banco de dados*/
public class SingleConnection {
	
	private static String url = "jdbc:postgresql://localhost:5432/agendatelefonica";
	private static String user = "postgres";
	private static String password = "admin";
	private static Connection con = null;

	
	private SingleConnection() {
		conectar();
	}
	
	private static void conectar() {
		try {
			if(con == null) {
				Class.forName("org.postgresql.Driver");
				con = DriverManager.getConnection(url,user, password);
				con.setAutoCommit(false);
				System.out.println("Conectou");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		return con;
	}
	
}
