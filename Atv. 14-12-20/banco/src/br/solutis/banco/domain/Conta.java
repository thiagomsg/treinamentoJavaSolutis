package br.solutis.banco.domain;

import br.solutis.banco.domain.enums.ContaEnum;

public abstract class Conta {
private static final Double SALDO_INICIAL = 0d;
private static Integer num=1;


	protected String nome;
	protected String cpf;
	protected String numConta;
	protected Double saldo;
	protected Double limite = 100d;
	protected ContaEnum tipoConta;
	
	public Conta() {
	
	}

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
	
	public String imprimir() {
		return toString();
	}
	
	public void transferir(Conta favorecido, Double valor) {
		sacar(valor);
		favorecido.depositar(valor);
	}
	
	public void sacar(Double valor) {
		this.saldo -= valor;
}
	
	public void depositar(Double valor) {
		this.saldo += valor;
		
	}
	
}
