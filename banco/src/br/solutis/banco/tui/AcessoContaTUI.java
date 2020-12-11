package br.solutis.banco.tui;

import java.util.Scanner;

import br.solutis.banco.dao.ContaDAO;
import br.solutis.banco.domain.Conta;

public class AcessoContaTUI {
	private static Scanner sc = new Scanner(System.in);
	public static void acessar() {
		String numConta;
		System.out.println("Digite o n�mero da conta");
		numConta = sc.nextLine();
		Conta conta = ContaDAO.selecionarConta(numConta);
		if(conta==null) {
			System.out.println("Conta n�o encontrada");
		}else {
			MovimentacaoTUI.menu(conta);
		}
	}
}
