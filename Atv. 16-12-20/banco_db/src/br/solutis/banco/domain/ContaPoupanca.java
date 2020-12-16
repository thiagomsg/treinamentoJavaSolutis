package br.solutis.banco.domain;

import br.solutis.banco.domain.enums.ContaEnum;

public class ContaPoupanca extends Conta {
	private static final Double FATOR_RENDIMENTO = 1000000d;
	private static final Double RENDIMENTO_MINIMO = 0.001d;
	private static final Double RENDIMENTO_MAXIMO = 0.01d;

	private Double rendimento;

	public ContaPoupanca(String nome, String cpf, ContaEnum tipoConta, Double depositoInicial) {
		super(nome, cpf, tipoConta, depositoInicial);
		calcularRendimento();

	}

	public Double getRendimento() {
		return rendimento;
	}

	public void setRendimento(Double rendimento) {
		this.rendimento = rendimento;
	}

	private void calcularRendimento() {
		this.rendimento = this.saldo / FATOR_RENDIMENTO;

		if (this.rendimento < RENDIMENTO_MINIMO) {
			this.rendimento = RENDIMENTO_MINIMO;

		} else if (this.rendimento > RENDIMENTO_MAXIMO) {
			this.rendimento = RENDIMENTO_MAXIMO;
		}
	}
	
	@Override
	public void sacar(Double valor) {
		this.saldo -= valor;
		calcularRendimento();
	}

	@Override
	public void depositar(Double valor) {
		this.saldo += valor;
		calcularRendimento();

	}

	@Override
	public String toString() {
		return "ContaPoupanca [rendimento=" + rendimento + ", nome=" + nome + ", cpf=" + cpf + ", numConta=" + numConta
				+ ", saldo=" + saldo + ", limite=" + limite + ", tipoConta=" + tipoConta + "]";
	}
	
	

}
