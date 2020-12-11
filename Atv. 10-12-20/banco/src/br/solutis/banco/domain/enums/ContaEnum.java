package br.solutis.banco.domain.enums;

public enum ContaEnum {
	
	CORRENTE("Corrente"),
	POUPANCA("Poupan�a"), 
	SALARIO("Sal�rio");

	private String descricao;
	
	/*O modificador private abaixo � dispens�vel, j� que o construtor de uma enum 
	  deve ser obrigatoriamente privado e o java faz a infer�ncia.*/
	private ContaEnum(String descricao) { 
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
