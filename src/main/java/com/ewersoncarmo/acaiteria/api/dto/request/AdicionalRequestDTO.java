package com.ewersoncarmo.acaiteria.api.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AdicionalRequestDTO {

	@NotNull
	@Positive
	@Max(value = 3)
	private Integer adicional;

	public Integer getAdicional() {
		return adicional;
	}

	public void setAdicional(Integer adicional) {
		this.adicional = adicional;
	}
	
}
