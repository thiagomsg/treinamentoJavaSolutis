package br.solutis.banco.tui;

import java.util.Scanner;

import br.solutis.banco.dao.ContaDAO;
import br.solutis.banco.domain.Conta;

public class AcessoContaTUI {
	private static Scanner sc = new Scanner(System.in);

	public static void acessar() {
		String opcao;
		boolean opcaoValida = false;
		Conta conta = null;
		do {
			System.out.println("Deseja acessar através do número da conta ou nome e cpf?");
			System.out.println("	1- Número da conta");
			System.out.println("	2- Nome e CPF");
			opcao = sc.nextLine();
			
			switch (opcao) {
			case "1":
				String numConta;
				System.out.println("Digite o número da conta");
				numConta = sc.nextLine();
				conta = ContaDAO.selecionarConta(numConta);
				if (conta == null) {
					System.out.println("Conta não encontrada");
				} else {
					MovimentacaoTUI.menu(conta);
				}
				opcaoValida = true;
				break;
			case "2":
				String nome;
				String cpf;
				System.out.println("Digite o nome:");
				nome = sc.nextLine();
				System.out.println("Digite o cpf:");
				cpf = sc.nextLine();
				conta = ContaDAO.selecionarConta(nome, cpf);
				if (conta == null) {
					System.out.println("Conta não encontrada");
				} else {
					MovimentacaoTUI.menu(conta);
				}
				opcaoValida = true;
				break;

			default:
				System.out.println("Por favor selecione uma opcao valida");
				break;
			}
		} while (opcaoValida == false);

	}
}
