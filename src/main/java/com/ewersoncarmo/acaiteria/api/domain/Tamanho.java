package com.ewersoncarmo.acaiteria.api.domain;

public enum Tamanho {

	PEQUENO(1, 10.0, 5, "Pequeno"),
	MEDIO(2, 13.0, 7, "Médio"),
	GRANDE(3, 15.0, 10, "Grande");
	
	private Integer codigo;
	private Double valor;
	private Integer tempoPreparo;
	private String descricao;

	private Tamanho(Integer codigo, Double valor, Integer tempoPreparo, String descricao) {
		this.codigo = codigo;
		this.valor = valor;
		this.tempoPreparo = tempoPreparo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public Double getValor() {
		return valor;
	}

	public Integer getTempoPreparo() {
		return tempoPreparo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public static Tamanho valueOf(int codigo) {
		for (Tamanho tamanho : values()) {
			if (tamanho.codigo == codigo) {
				return tamanho;
			}
		}
		
		return null;
	}
}
