package com.iec.cbfapi.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "partida")
public class Partida implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Instant dataHora;
	private Long placarMandante;
	private Long placarVisitante;
	
	@ManyToOne
	@JoinColumn(name = "id_time_mandante")
	private Time timeMandante;
	
	@ManyToOne
	@JoinColumn(name = "id_time_visitante")
	private Time timeVisitante;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id_torneio")
	private Torneio torneio;
	
	@OneToMany(mappedBy = "partida")
	private List<Evento> eventos = new ArrayList<>();
	
	public Partida() {}

	public Partida(Long id, Instant dataHora, Long placarMandante, Long placarVisitante, Time timeMandante,
			Time timeVisitante, Torneio torneio) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.placarMandante = placarMandante;
		this.placarVisitante = placarVisitante;
		this.timeMandante = timeMandante;
		this.timeVisitante = timeVisitante;
		this.torneio = torneio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDataHora() {
		return dataHora;
	}

	public void setDataHora(Instant dataHora) {
		this.dataHora = dataHora;
	}

	public Long getPlacarMandante() {
		return placarMandante;
	}

	public void setPlacarMandante(Long placarMandante) {
		this.placarMandante = placarMandante;
	}

	public Long getPlacarVisitante() {
		return placarVisitante;
	}

	public void setPlacarVisitante(Long placarVisitante) {
		this.placarVisitante = placarVisitante;
	}

	public Time getTimeMandante() {
		return timeMandante;
	}

	public void setTimeMandante(Time timeMandante) {
		this.timeMandante = timeMandante;
	}

	public Time getTimeVisitante() {
		return timeVisitante;
	}

	public void setTimeVisitante(Time timeVisitante) {
		this.timeVisitante = timeVisitante;
	}

	public Torneio getTorneio() {
		return torneio;
	}

	public void setTorneio(Torneio torneio) {
		this.torneio = torneio;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
	
	
}
