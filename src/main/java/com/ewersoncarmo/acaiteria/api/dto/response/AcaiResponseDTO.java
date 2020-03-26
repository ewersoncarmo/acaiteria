package com.ewersoncarmo.acaiteria.api.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_EMPTY)
public class AcaiResponseDTO {

	private String tamanho;
	private String sabor;
	private Double valorItem;
	private List<AdicionalResponseDTO> adicionais;

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public Double getValorItem() {
		return valorItem;
	}

	public void setValorItem(Double valorItem) {
		this.valorItem = valorItem;
	}

	public List<AdicionalResponseDTO> getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(List<AdicionalResponseDTO> adicionais) {
		this.adicionais = adicionais;
	}
	
}
