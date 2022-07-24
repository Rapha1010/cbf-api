package com.iec.cbfapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iec.cbfapi.entities.Evento;
import com.iec.cbfapi.entities.Partida;
import com.iec.cbfapi.entities.RedisEvento;
import com.iec.cbfapi.repositories.EventoRepository;
import com.iec.cbfapi.repositories.RedisEventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository er;
	
	@Autowired
	private PartidaService ps;
	
	@Autowired
	private RabbitmqService rs;
	
	@Autowired
	private RedisEventoRepository redisEventoRepository;

	public List<RedisEvento> findAllByPartidaId(Long partidaId) {
		List<RedisEvento> evento = redisEventoRepository.findAll(hashKey(partidaId));
		return evento;
	}
	
	public Evento insert(Long partidaId, Evento obj) {
		Partida partida = ps.findById(partidaId);
		Evento evento = new Evento(null, obj.getDescricao(), partida);
		Evento responseSave = er.save(evento);
		
		saveEventoInRabbitMq(responseSave);
		saveEventoInRedis(responseSave);
		return responseSave;
	}
	
	public String hashKey(Long partidaId) {
		Partida partida = ps.findById(partidaId);
		String hashKey = "torneio_"+partida.getTorneio().getId()+"_partida_"+partida.getId();
		return hashKey;
	}
	
	public void saveEventoInRedis(Evento evento) {
		RedisEvento redisEvento = new RedisEvento();
		redisEvento.setId(evento.getId());
		redisEvento.setDataHora(evento.getDataHora());
		redisEvento.setDescricao(evento.getDescricao());
		redisEvento.setIdPartida(evento.getPartida().getId());
		redisEventoRepository.save(hashKey(evento.getPartida().getId()),redisEvento);
	}
	
	public void saveEventoInRabbitMq(Evento evento) {
		rs.sendMessage("EVENTOS", evento);
	}

}
