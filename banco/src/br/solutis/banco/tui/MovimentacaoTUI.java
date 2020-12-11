package br.solutis.banco.tui;

import java.util.Scanner;

import br.solutis.banco.dao.ContaDAO;
import br.solutis.banco.domain.Conta;

public class MovimentacaoTUI {
	private static Scanner sc = new Scanner(System.in);

	public static void menu(Conta conta) {
		String opcao;
		boolean opcaoValida = false;
		System.out.println("Bem vindo " + conta.getNome() + "! Selecione a ação desejada");
		do {
			System.out.println("   1- Depósito");
			System.out.println("   2- Saque");
			System.out.println("   3- Transferência");
			System.out.println("   4- Exibir dados");
			opcao = sc.nextLine();

			switch (opcao) {
			case "1":
				depositar(conta);
				opcaoValida = true;
				break;
			case "2":
				sacar(conta);
				opcaoValida = true;
				break;
			case "3":
				transferir(conta);
				opcaoValida = true;
				break;
			case "4":
				ContaDAO.imprimir(conta.getNumConta());;
				opcaoValida = true;
				break;

			default:
				System.out.println("Digite uma opção válida");
				break;
			}
		} while (opcaoValida == false);
	}

	private static void transferir(Conta conta) {
		String numContaFavorecido;
		Double valor;
		System.out.println("Digite o número da conta do favorecido");
		numContaFavorecido = sc.nextLine();
		Conta favorecido = ContaDAO.selecionarConta(numContaFavorecido);
		if (conta.getTipoConta().getDescricao().equals(favorecido.getTipoConta().getDescricao())) {
			System.out.println("Digite o valor a transferir");
			valor = sc.nextDouble();
			sc.nextLine();
			if (valor <= conta.getSaldo()) {
				conta.setSaldo(conta.getSaldo() - valor);
				conta.setLimite();
				favorecido.setSaldo(favorecido.getSaldo() + valor);
				favorecido.setLimite();
				System.out.println("Você transferiu R$ " + valor + " para " + favorecido.getNome());
			} else {
				System.out.println("Saldo insuficiente.");
			}

		} else {
			System.out.println("Você não pode transferir de conta " + conta.getTipoConta().getDescricao()
					+ " para conta " + favorecido.getTipoConta().getDescricao());
		}

	}

	private static void sacar(Conta conta) {
		Double valor;
		do {
			System.out.println("Digite o valor a sacar:");
			valor = sc.nextDouble();
			sc.nextLine();
			if (valor > conta.getLimite()) {
				System.out.println("Valor é superior ao limite de R$" + conta.getLimite());
			}
		} while (valor > conta.getLimite());
		if (valor <= conta.getSaldo()) {
			conta.setSaldo(conta.getSaldo() - valor);
			conta.setLimite();
			System.out.println("Você sacou R$ " + valor);
		} else {
			System.out.println("Saldo insuficiente.");
		}

	}

	private static void depositar(Conta conta) {
		Double valor;
		System.out.println("Digite o valor a depositar:");
		valor = sc.nextDouble();
		sc.nextLine();
		conta.setSaldo(conta.getSaldo() + valor);
		System.out.println("Deposito de R$ " + valor + " realizado com sucesso.\n");

	}

}
