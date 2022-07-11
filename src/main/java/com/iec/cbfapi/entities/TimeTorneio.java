package com.iec.cbfapi.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.iec.cbfapi.entities.pk.TimeTorneioPK;

@Entity
@Table(name = "time_torneio")
public class TimeTorneio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private TimeTorneioPK id;
	
	@ManyToOne
	@MapsId("timeId")
	private Time time;
	
	@ManyToOne
	@MapsId("torneioId")
	private Torneio torneio;
	
	@Column
	private Instant criadoEm;

	public TimeTorneio() {}

	public TimeTorneio(TimeTorneioPK id, Time time, Torneio torneio) {
		super();
		this.id = id;
		this.time = time;
		this.torneio = torneio;
		this.criadoEm = Instant.now();
	}

	public TimeTorneioPK getId() {
		return id;
	}

	public void setId(TimeTorneioPK id) {
		this.id = id;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Torneio getTorneio() {
		return torneio;
	}

	public void setTorneio(Torneio torneio) {
		this.torneio = torneio;
	}

	public Instant getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(Instant criadoEm) {
		this.criadoEm = criadoEm;
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
		TimeTorneio other = (TimeTorneio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
