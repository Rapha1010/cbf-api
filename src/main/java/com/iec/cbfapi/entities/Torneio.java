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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@NotBlank
	private String nome; 
	@NotBlank
	private String localDisputa;
	@NotBlank
	private String organizacao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "torneio")
	private List<TimeTorneio> times = new ArrayList<>();
	
	@OneToMany(mappedBy = "torneio")
	private List<Partida> partidas = new ArrayList<>();
	
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

	public List<TimeTorneio> getTimes() {
		return times;
	}

	public void setTimes(List<TimeTorneio> times) {
		this.times = times;
	}

	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Torneio other = (Torneio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
