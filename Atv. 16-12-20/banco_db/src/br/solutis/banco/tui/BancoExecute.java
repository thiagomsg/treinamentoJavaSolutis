package br.solutis.banco.tui;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.solutis.banco.dao.ContaDAO;

public class BancoExecute {
	private static final int DEFAULT_OPTION = 99; 
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Isso vai virar um banco com banco de dados. Será?");
		inicio();
	}

	private static void inicio() {
		Integer opcao;
		do {
			System.out.println("Olá! Selecione a opção desejada.");
			System.out.println("1- Abrir Conta");
			System.out.println("2- Acessar Conta");
			System.out.println("0- Sair ");
			System.out.println("9- Listar todas as contas");
			
			
			
			try {
				opcao = sc.nextInt();

			} catch (InputMismatchException e) {
				opcao = DEFAULT_OPTION;
				sc.nextLine();
			}

			switch (opcao) {
			case 1:
				AberturaContaTUI.abrirConta();
				break;
			case 2:
				AcessoContaTUI.acessar();
				break;
			case 0:
				System.out.println("Tchau! *-*");
				break;
			case 9:
				System.out.println(ContaDAO.listarContas());
				break;
			case DEFAULT_OPTION:
				System.out.println("Por favor digite um número válido.");
				break;

			default:
				System.out.println("Por favor selecione uma opção válida.");
				break;
			}
			
		} while (opcao == null || opcao != 0);
	}
}
