package com.iec.cbfapi.services;

import java.time.Instant;
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
	
	@Autowired
	private PartidaService ps;
	
	@Autowired
	private RabbitmqService rs;

	public List<Evento> findAllByPartidaId(Long partidaId) {
		List<Evento> evento = er.findAllByPartidaId(partidaId);
		return evento;
	}
	
	public Evento insert(Long partidaId, Evento obj) {
		
		Partida partida = ps.findById(partidaId);
	    Evento evento = new Evento(null, obj.getDescricao(), partida);
	    
	    rs.sendMessage("EVENTOS", evento);
	    
		return er.save(evento);
	}
	
	

}
