package cursoSolutis;

import java.sql.Connection;
import java.util.Calendar;

public class Main {
	public static void main(String[] args) {
		Connection conn = new ConnectionFactory().getConnection();
	System.out.println("Conexão aberta com Sucesso!");
	Contato contato = new Contato();
	contato .setNome("Joao Silva");
	contato.setEndereco("Rua 34");
	contato.setEmail("tote@gth.com");
	contato.setDataNascimento(Calendar.getInstance());
	ContatoDAO contatoDAO = new ContatoDAO();
	contatoDAO.inserir(contato);
	System.out.println("Contato Salvo");
	}
}
