package com.ewersoncarmo.acaiteria.api.domain;

public enum Adicional {

	GRANOLA(1, 0.0, 0, "Granola"),
	PACOCA(2, 3.0, 3, "Paçoca"),
	LEITE_NINHO(3, 3.00, 0, "Leite Ninho");
	
	private Integer codigo;
	private Double valor;
	private Integer tempoPreparo;
	private String descricao;

	private Adicional(Integer codigo, Double valor, Integer tempoPreparo, String descricao) {
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

	public static Adicional valueOf(int codigo) {
		for (Adicional adicional : values()) {
			if (adicional.codigo == codigo) {
				return adicional;
			}
		}
		
		return null;
	}
}
