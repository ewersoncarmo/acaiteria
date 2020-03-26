package com.ewersoncarmo.acaiteria.api.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class PedidoRequestDTO {

	@NotNull
	@Valid
	private AcaiRequestDTO acai;

	public AcaiRequestDTO getAcai() {
		return acai;
	}

	public void setAcai(AcaiRequestDTO acai) {
		this.acai = acai;
	}
	
}
