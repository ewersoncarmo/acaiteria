package com.ewersoncarmo.acaiteria.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Adicionais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Integer adicional;
	
	@ManyToOne
	@JoinColumn(name = "acai_id")
	private Acai acai;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAdicional() {
		return adicional;
	}

	public void setAdicional(Integer adicional) {
		this.adicional = adicional;
	}

	public Acai getAcai() {
		return acai;
	}

	public void setAcai(Acai acai) {
		this.acai = acai;
	}
	
}
