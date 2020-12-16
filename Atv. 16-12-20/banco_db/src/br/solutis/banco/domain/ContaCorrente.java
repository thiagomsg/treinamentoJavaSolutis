package br.solutis.banco.domain;

import br.solutis.banco.domain.enums.ContaEnum;

public class ContaCorrente extends Conta {
	private Integer milhas;

	public ContaCorrente(String nome, String cpf, ContaEnum tipoConta, Double depositoInicial) {
		super(nome, cpf, tipoConta, depositoInicial);
		this.milhas = (int) (depositoInicial / 10);
	}

	public Integer getMilhas() {
		return milhas;
	}

	public void setMilhas(Integer milhas) {
		this.milhas = milhas;
	}
	
	@Override
	public void depositar(Double valor) {
		this.saldo += valor;
		Integer milhas = (int) (valor / 10);
		addMilhas(milhas);
	}

	private void addMilhas(Integer milhas) {
		this.milhas += milhas;
	}

	@Override
	public String toString() {
		return "ContaCorrente [milhas=" + milhas + ", nome=" + nome + ", cpf=" + cpf + ", numConta=" + numConta
				+ ", saldo=" + saldo + ", limite=" + limite + ", tipoConta=" + tipoConta + "]";
	}
	
}
