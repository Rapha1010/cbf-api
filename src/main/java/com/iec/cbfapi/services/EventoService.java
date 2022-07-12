package com.iec.cbfapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iec.cbfapi.entities.Evento;
import com.iec.cbfapi.entities.Partida;
import com.iec.cbfapi.repositories.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository er;

	public List<Evento> findAllByPartidaId(Long partidaId) {
		List<Evento> evento = er.findAllByPartidaId(partidaId);
		return evento;
	}
	
	

}
