package br.solutis.banco.domain;

import br.solutis.banco.domain.enums.ContaEnum;

public class ContaSalario extends Conta {
	
	private Integer consultasRestantes;

	public ContaSalario(String nome, String cpf, ContaEnum tipoConta, Double depositoInicial) {
		super(nome, cpf, tipoConta, depositoInicial);
		this.consultasRestantes = 5;
	}

	public Integer getConsultasRestantes() {
		return consultasRestantes;
	}

	public void setConsultasRestantes(Integer consultasRestantes) {
		this.consultasRestantes = consultasRestantes;
	}	
	
	@Override
	public String imprimir() {
		if(this.consultasRestantes <= 0) {
			return "Limite de consultas mensais atingido para conta salário,\nabra uma conta corrente para consultas ilimitadas e outros benefícios.\n";
		}
		this.consultasRestantes--;
		return toString() + "\nVocê ainda pode realizar mais "+getConsultasRestantes()+" consultas este mês.";
		
	}

	@Override
	public String toString() {
		return "ContaSalario [consultasRestantes=" + consultasRestantes + ", nome=" + nome + ", cpf=" + cpf
				+ ", numConta=" + numConta + ", saldo=" + saldo + ", limite=" + limite + ", tipoConta=" + tipoConta
				+ "]";
	}
}
