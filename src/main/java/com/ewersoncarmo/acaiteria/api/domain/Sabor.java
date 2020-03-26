package com.ewersoncarmo.acaiteria.api.domain;

public enum Sabor {

	MORANGO(1, 0, "Morango"),
	BANANA(2, 0, "Banana"),
	KIWI(3, 5, "Kiwi");

	private Integer codigo;
	private Integer tempoExtra;
	private String descricao;

	private Sabor(Integer codigo, Integer tempoExtra, String descricao) {
		this.codigo = codigo;
		this.tempoExtra = tempoExtra;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public Integer getTempoExtra() {
		return tempoExtra;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Sabor valueOf(int codigo) {
		for (Sabor sabor : values()) {
			if (sabor.codigo == codigo) {
				return sabor;
			}
		}
		
		return null;
	}

}
