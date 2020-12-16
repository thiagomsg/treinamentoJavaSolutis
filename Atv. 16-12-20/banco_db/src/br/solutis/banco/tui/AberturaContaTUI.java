package br.solutis.banco.tui;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.solutis.banco.dao.ContaDAO;
import br.solutis.banco.domain.Conta;
import br.solutis.banco.domain.ContaCorrente;
import br.solutis.banco.domain.ContaPoupanca;
import br.solutis.banco.domain.ContaSalario;
import br.solutis.banco.domain.enums.ContaEnum;

public class AberturaContaTUI {
	private static Scanner sc = new Scanner(System.in);

	public static void abrirConta() {
		String nome;
		String cpf;
		String opcaoGenerica;
		boolean opcaoValida = false;
		ContaEnum tipoConta = null;
		Double depositoInicial = 0d;
		Conta conta = null;
		ContaDAO contaDAO = new ContaDAO();

		System.out.println("Digite seu nome: ");
		nome = sc.nextLine();
		System.out.println("Digite seu cpf: ");
		cpf = sc.nextLine();
		System.out.println("Qual o tipo da conta?");

		do {
			System.out.println("   1- Corrente");
			System.out.println("   2- Poupança");
			System.out.println("   3- Salário");
			opcaoGenerica = sc.nextLine();

			switch (opcaoGenerica) {
			case "1":
				tipoConta = ContaEnum.CORRENTE;
				break;
			case "2":
				tipoConta = ContaEnum.POUPANCA;
				break;
			case "3":
				tipoConta = ContaEnum.SALARIO;
				break;

			default:
				System.out.println("Selecione uma opção válida.");
				break;
			}
		} while (opcaoGenerica == null || tipoConta == null);

		System.out.println("Deseja fazer um depósito inicial?");
		do {
			System.out.println("   1- Sim");
			System.out.println("   2- Não");
			opcaoGenerica = sc.nextLine();

			switch (opcaoGenerica) {
			case "1":
				System.out.println("Digite o valor: ");
				do {
					try {
						depositoInicial = sc.nextDouble();
						sc.nextLine();
						opcaoValida = true;

					} catch (InputMismatchException e) {
						System.out.println("Por favor digite um valor numérico: ");
						sc.nextLine();
					}
				} while (opcaoValida == false);
				break;
			case "2":
				opcaoValida = true;
				break;

			default:
				System.out.println("Por favor selecione uma opção válida.");
				break;
			}
		} while (opcaoValida == false);

		switch (tipoConta) {
		case CORRENTE:
			conta = new ContaCorrente(nome, cpf, tipoConta, depositoInicial);
			contaDAO.inserir(conta);
			break;
		case POUPANCA:
			conta = new ContaPoupanca(nome, cpf, tipoConta, depositoInicial);
			contaDAO.inserir(conta);
			break;
		case SALARIO:
			conta = new ContaSalario(nome, cpf, tipoConta, depositoInicial);
			contaDAO.inserir(conta);
			break;

		default:
			break;
		}
		System.out.println("Conta criada com sucesso!\n");
		System.out.println("Número da conta: " + conta.getNumConta());
		System.out.println("Tipo: " + conta.getTipoConta().getDescricao());
		System.out.println("Saldo: " + conta.getSaldo());
		System.out.println("Numero de contas: " + ContaDAO.tamanho() + "\n");
	}

}
