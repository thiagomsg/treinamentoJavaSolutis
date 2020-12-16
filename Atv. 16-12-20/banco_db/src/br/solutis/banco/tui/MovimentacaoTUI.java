package br.solutis.banco.tui;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.solutis.banco.dao.ContaDAO;
import br.solutis.banco.domain.Conta;

public class MovimentacaoTUI {
	private static Scanner sc = new Scanner(System.in);

	public static void menu(Conta conta) {
		String opcao;
		boolean opcaoValida = false;
		do {
			System.out.println("Bem vindo " + conta.getNome() + "! Selecione a ação desejada:");
			System.out.println("   1- Depósito");
			System.out.println("   2- Saque");
			System.out.println("   3- Transferência");
			System.out.println("   4- Exibir dados");
			System.out.println("   0- Sair");
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
				imprimir(conta);
				opcaoValida = true;
				break;
			case "0":
				opcaoValida = true;
				break;

			default:
				System.out.println("Digite uma opção válida");
				break;
			}
		} while (opcaoValida == false || !opcao.equals("0"));
	}
	
	private static void imprimir(Conta conta) {
		String dados = conta.imprimir();
		System.out.println(dados);
	}

	private static void transferir(Conta conta) {
		String numContaFavorecido;
		Double valor = 0d;
		boolean isNumber = false;
		System.out.println("Digite o número da conta do favorecido");
		numContaFavorecido = sc.nextLine();
		Conta favorecido = ContaDAO.selecionarConta(numContaFavorecido);

		if (conta.getTipoConta().getDescricao().equals(favorecido.getTipoConta().getDescricao())) {
			System.out.println("Digite o valor a transferir");
			do {
				try {
					valor = sc.nextDouble();
					sc.nextLine();
					isNumber = true;

				} catch (InputMismatchException e) {
					System.out.println("Por favor digite um valor válido: ");
					sc.nextLine();
				}
			} while (isNumber == false);

			if (valor <= conta.getSaldo()) {
				conta.transferir(favorecido, valor);
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
		Double valor = 0d;
		boolean isNumber = false;
		System.out.println("Digite o valor a sacar: ");
		do {
			try {
				valor = sc.nextDouble();
				sc.nextLine();
				isNumber = true;

			} catch (InputMismatchException e) {
				System.out.println("Por favor digite um valor válido: ");
				sc.nextLine();
			}
		} while (isNumber == false);

		if (valor <= conta.getSaldo() + conta.getLimite()) {
			conta.sacar(valor);
			System.out.println("Você sacou R$ " + valor);
		} else {
			System.out.println("Saldo insuficiente.");
		}

	}

	private static void depositar(Conta conta) {
		Double valor = 0d;
		boolean isNumber = false;
		System.out.println("Digite o valor a depositar: ");
		do {
			try {
				valor = sc.nextDouble();
				sc.nextLine();
				isNumber = true;

			} catch (InputMismatchException e) {
				System.out.println("Por favor digite um valor válido: ");
				sc.nextLine();
			}
		} while (isNumber == false);

		conta.depositar(valor);
		System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");

	}

}
