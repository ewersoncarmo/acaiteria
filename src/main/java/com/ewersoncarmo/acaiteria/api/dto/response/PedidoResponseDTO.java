package com.ewersoncarmo.acaiteria.api.dto.response;

public class PedidoResponseDTO {

	private Long id;
	private AcaiResponseDTO acai;
	private Integer tempoPreparo;
	private Double valorTotal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AcaiResponseDTO getAcai() {
		return acai;
	}

	public void setAcai(AcaiResponseDTO acai) {
		this.acai = acai;
	}

	public Integer getTempoPreparo() {
		return tempoPreparo;
	}

	public void setTempoPreparo(Integer tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
