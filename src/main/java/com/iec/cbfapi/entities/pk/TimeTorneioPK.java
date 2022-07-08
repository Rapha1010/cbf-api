package com.iec.cbfapi.entities.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TimeTorneioPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "time_id")
	private Long timeId;
	
	@Column(name = "torneio_id")
	private Long torneioId;
	
	public TimeTorneioPK() {}

	public TimeTorneioPK(Long timeId, Long torneioId) {
		super();
		this.timeId = timeId;
		this.torneioId = torneioId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((timeId == null) ? 0 : timeId.hashCode());
		result = prime * result + ((torneioId == null) ? 0 : torneioId.hashCode());
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
		TimeTorneioPK other = (TimeTorneioPK) obj;
		if (timeId == null) {
			if (other.timeId != null)
				return false;
		} else if (!timeId.equals(other.timeId))
			return false;
		if (torneioId == null) {
			if (other.torneioId != null)
				return false;
		} else if (!torneioId.equals(other.torneioId))
			return false;
		return true;
	}

}
