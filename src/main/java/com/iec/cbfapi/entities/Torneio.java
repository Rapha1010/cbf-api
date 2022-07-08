package com.iec.cbfapi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "torneio")
public class Torneio implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome; 
	private String localDisputa;
	private String organizacao;
	
	@OneToMany(mappedBy = "torneio")
	private List<TimeTorneio> times = new ArrayList<>();
	
	public Torneio() {
	}

	public Torneio(Long id, String nome, String localDisputa, String organizacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.localDisputa = localDisputa;
		this.organizacao = organizacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocalDisputa() {
		return localDisputa;
	}

	public void setLocalDisputa(String localDisputa) {
		this.localDisputa = localDisputa;
	}

	public String getOrganizacao() {
		return organizacao;
	}

	public void setOrganizacao(String organizacao) {
		this.organizacao = organizacao;
	}

}
