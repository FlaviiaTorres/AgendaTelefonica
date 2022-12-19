package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaoJDBC.SingleConnection;
import model.Agenda;

public class UserAgendaDAO {
	
	private Connection con;
	
	
	public UserAgendaDAO() {
		con = SingleConnection.getConnection();	
		}
	
	public void salvarContato (Agenda agenda) { /*Salva o contato no banco de dados*/
		try {
			String sql = "insert into agenda (nome, numerotel) values(?, ?)";
			PreparedStatement insert = con.prepareStatement(sql);
			insert.setString(1, agenda.getNome());
			insert.setInt(2, agenda.getNumeroTel());
			insert.execute();
			con.commit();

		} catch (Exception e) {
			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			e.printStackTrace();		}
		
	}
	
	public List<Agenda> listar() throws Exception { /*Lista todos os contatos salvos no banco de dados*/
		List<Agenda> list = new ArrayList<Agenda>();

		String sql = "select * from agenda";
		PreparedStatement statement = con.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {
			Agenda ag = new Agenda();
			ag.setId(resultado.getLong("id"));
			ag.setNome(resultado.getString("nome"));
			ag.setNumeroTel(resultado.getInt("numeroTel"));

			list.add(ag); 
		}

		return list;
	}
	
	public Agenda pesquisar(Long id) throws Exception { /*Pesquisar por id*/
		Agenda retorno = new Agenda();
		String sql = "select * from agenda where id = " +id;
		PreparedStatement statement = con.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		while (resultado.next()) {
			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setNumeroTel(resultado.getInt("numeroTel"));
		}
		return retorno;
	}
	
	public void atualizar(Agenda ag) { /*Atualiza pelo o ID informado*/
		try {
			String sql = "update agenda set nome = ? where id = " + ag.getId();

			PreparedStatement statement = con.prepareStatement(sql); 
			statement.setString(1, ag.getNome()); 
			statement.execute(); 
			con.commit(); 

		} catch (Exception e) {
			try {
				con.rollback();// Reverte caso dê algum erro
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public void deletar(Long id) { /*Deleta pelo ID informado*/
		try {

			String sql = "delete from agenda where id = " + id; 
			PreparedStatement statement = con.prepareStatement(sql); 
			statement.execute();
			con.commit();

		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
	}
	
	
	
}
