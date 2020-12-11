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
	public static void imprimir(String numConta) {
		for (Conta conta : contas) {
			if (conta.getNumConta().equals(numConta)) {
				System.out.println("Nome: " + conta.getNome());
				System.out.println("CPF: " + conta.getCpf());
				System.out.println("Número da conta: " + conta.getNumConta());
				System.out.println("Tipo: " + conta.getTipoConta().getDescricao());
				System.out.println("Saldo: " + conta.getSaldo());
				System.out.println("Limite: " + conta.getLimite()+"\n");
				return;
			}
		}
		System.out.println("Conta não encontrada.");
	}
}
