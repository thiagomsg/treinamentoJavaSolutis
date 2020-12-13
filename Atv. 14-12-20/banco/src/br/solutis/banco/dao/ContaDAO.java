package br.solutis.banco.dao;

import java.util.ArrayList;
import java.util.List;

import br.solutis.banco.domain.Conta;

public class ContaDAO {
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
