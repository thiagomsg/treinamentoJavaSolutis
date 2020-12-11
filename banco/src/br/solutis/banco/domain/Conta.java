package br.solutis.banco.domain;

import br.solutis.banco.domain.enums.ContaEnum;

public class Conta {
private static final Double SALDO_INICIAL = 0d;
private static Integer num=1;


	private String nome;
	private String cpf;
	private String numConta;
	private Double saldo;
	private Double limite = 100d;
	private ContaEnum tipoConta;

	public Conta(String nome, String cpf, ContaEnum tipoConta, Double depositoInicial) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.tipoConta = tipoConta;
		this.numConta = num.toString();
		this.saldo = SALDO_INICIAL + depositoInicial;
		if(this.saldo>500) {
			this.limite = 300d;
		}
		num++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumConta() {
		return numConta;
	}

	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getLimite() {
		return this.limite;
	}
	public void setLimite() {
		if(this.saldo > 500) {
		this.limite = 300d;
		}else {
			this.limite = 100d;
		}
		
	}

	public ContaEnum getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(ContaEnum tipoConta) {
		this.tipoConta = tipoConta;
	}
}
