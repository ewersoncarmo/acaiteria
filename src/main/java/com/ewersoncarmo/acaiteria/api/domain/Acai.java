package com.ewersoncarmo.acaiteria.api.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Acai {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Integer tamanho;
	
	@Column
	private Integer sabor;
	
	@OneToMany(mappedBy = "acai", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Adicionais> adicionais = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public List<Adicionais> getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(List<Adicionais> adicionais) {
		this.adicionais = adicionais;
	}

}
