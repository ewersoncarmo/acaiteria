package com.ewersoncarmo.acaiteria.api.dto.request;

import java.util.List;

import javax.validation.Valid;

public class PersonalizacaoRequestDTO {

	@Valid
	private List<AdicionalRequestDTO> adicionais;

	public List<AdicionalRequestDTO> getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(List<AdicionalRequestDTO> adicionais) {
		this.adicionais = adicionais;
	}
	
}
