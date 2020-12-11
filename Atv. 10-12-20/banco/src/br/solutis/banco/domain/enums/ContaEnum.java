package br.solutis.banco.domain.enums;

public enum ContaEnum {
	
	CORRENTE("Corrente"),
	POUPANCA("Poupança"), 
	SALARIO("Salário");

	private String descricao;
	
	/*O modificador private abaixo é dispensável, já que o construtor de uma enum 
	  deve ser obrigatoriamente privado e o java faz a inferência.*/
	private ContaEnum(String descricao) { 
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
