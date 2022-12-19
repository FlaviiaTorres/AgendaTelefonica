package agendaTelefonica.agenda;

import java.util.List;

import org.junit.Test;

import dao.UserAgendaDAO;
import model.Agenda;


public class iniciarConexaoJDBC {
	
	UserAgendaDAO userAgendaDAO = new UserAgendaDAO();
	Agenda agenda = new Agenda();
	
	@Test
	public void iniBanco() {
		
		agenda.setNome("Flávia");
		agenda.setNumeroTel(88494192);
		agenda.setNome("Tainar");
		agenda.setNumeroTel(34368890);
		
		userAgendaDAO.salvarContato(agenda);
		
	}
	
	@Test
	public void initListar() {
		UserAgendaDAO dao = new UserAgendaDAO();
		try {
			List<Agenda> list = dao.listar();

			for (Agenda ag : list) {
				System.out.println(ag);
				System.out.println("----------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initPesquisar() {
		UserAgendaDAO dao = new UserAgendaDAO();
		try {
			Agenda ag = dao.pesquisar(3L);
			
			System.out.println(ag);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initAtualizar() {
		try {

			UserAgendaDAO dao = new UserAgendaDAO();

			Agenda objetoBanco = dao.pesquisar(5L);

			objetoBanco.setNome("Nome mudado com metodo atualizar");

			dao.atualizar(objetoBanco);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void initDeletar() {

		try {

			UserAgendaDAO dao = new UserAgendaDAO();
			dao.deletar(11L);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
}
