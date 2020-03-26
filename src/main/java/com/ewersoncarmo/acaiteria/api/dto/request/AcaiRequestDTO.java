package com.ewersoncarmo.acaiteria.api.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AcaiRequestDTO {

	@NotNull
	@Positive
	@Max(value = 3)
	private Integer tamanho;
	
	@NotNull
	@Positive
	@Max(value = 3)
	private Integer sabor;

	public Integer getTamanho() {
		return tamanho;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}

	public Integer getSabor() {
		return sabor;
	}

	public void setSabor(Integer sabor) {
		this.sabor = sabor;
	}

}
