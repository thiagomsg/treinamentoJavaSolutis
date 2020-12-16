package br.solutis.banco.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.solutis.banco.configDB.ConnectionFactory;
import br.solutis.banco.domain.Conta;

public class ContaDAO {
	private Connection conn;
	
	public void inserir(Conta conta) {
		String sql = "insert into conta " +
                "(numero,nome,cpf,saldo,limite,tipo)" +
                " values (?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,conta.getNumConta());
			stmt.setString(2,conta.getNome());
			stmt.setString(3,conta.getCpf());
			stmt.setDouble(4, conta.getSaldo());
			stmt.setDouble(5, conta.getLimite());
			stmt.setString(6, conta.getTipoConta().getDescricao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Conta inserida no banco de dados!");
	}
	
	
	
	
	
	
	/////////////////////////////////////////////////////////////////////
	public ContaDAO() {
		this.conn = new ConnectionFactory().getConnection();
	}
	
	private static List<Conta> contas = new ArrayList<>();

	public static void salvar(Conta conta) {
		contas.add(conta);
	}

	public static int tamanho() {
		return contas.size();
	}

	public static Conta selecionarConta(String numConta) {
		for (Conta conta : contas) {
			if (conta.getNumConta().equals(numConta)) {
				return conta;
			}
		}
		return null;
	}

	public static Conta selecionarConta(String nome, String cpf) {
		for (Conta conta : contas) {
			if (conta.getNome().equals(nome) && conta.getCpf().equals(cpf)) {
				return conta;
			}
		}
		return null;
	}

	public static String listarContas() {
		String contas="";
		for (Conta conta : ContaDAO.contas) {
			contas += conta.toString() + "\n";
		}
		
		if (!contas.equals("")) {
			return contas;
		}
		
		return "Não há contas cadastradas no sistema.\n";
	}

}
