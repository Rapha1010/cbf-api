package com.iec.cbfapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iec.cbfapi.entities.Evento;
import com.iec.cbfapi.entities.Partida;
import com.iec.cbfapi.entities.RedisEvento;
import com.iec.cbfapi.entities.Torneio;
import com.iec.cbfapi.services.EventoService;
import com.iec.cbfapi.services.PartidaService;
import com.iec.cbfapi.services.TorneioService;

@RestController
@RequestMapping(value = "/cbf-api/torneios")
public class TorneioController {

	private static final Logger logger = LogManager.getLogger(TorneioController.class);

	@Autowired
	private TorneioService ts;
	
	@Autowired
	private EventoService es;
	
	@Autowired
	private PartidaService ps;
	
	@GetMapping
	public ResponseEntity<List<Torneio>> findAll() {
		List<Torneio> list = ts.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Torneio> findById(@PathVariable Long id) {
		Torneio torneio = ts.findById(id);
		logger.info("ENDPOINT (FINDBYID TORNEIO) TORNEIO_ID REQUESTED="+ id);
		
		if(torneio == null) return ResponseEntity.notFound().build();
	
		return ResponseEntity.ok().body(torneio);
	}
	
	@GetMapping(value ="/{id}/partidas")
	public ResponseEntity<List<Partida>> findAllPartidas(@PathVariable Long id) {
		List<Partida> list = ps.findAllByTorneioId(id);
		logger.info("ENDPOINT (FINDALL PARTIDA) TORNEIO_ID REQUESTED="+ id);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value ="/{id}/partidas/{partidaId}")
	public ResponseEntity<Partida> findPartida(@PathVariable Long id, @PathVariable Long partidaId) {
		Partida partida = ps.findByIdAndTorneioId(id, partidaId);
		logger.info("ENDPOINT (FINDBYID PARTIDA) REQUESTED TORNEIO_ID = " +id+", PARTIDA_ID ="+partidaId);
		
		if (partida == null) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().body(partida);
	}
	
	@GetMapping(value ="/{id}/partidas/{partidaId}/eventos")
	public ResponseEntity<List<RedisEvento>> findAllEventsByPartida(@PathVariable Long id, @PathVariable Long partidaId) {
		logger.info("ENDPOINT (FINDBYID PARTIDA) REQUESTED TORNEIO_ID = " +id+", PARTIDA_ID ="+partidaId);
		List<RedisEvento> list = es.findAllByPartidaId(partidaId);
		
		if(!list.isEmpty())
			return ResponseEntity.ok().body(list);
		else
			return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping
	public ResponseEntity<Torneio> insert(@Valid @RequestBody Torneio obj) {
		return new ResponseEntity<>(ts.insert(obj), HttpStatus.CREATED);
	}
	
	@RequestMapping(value ="/{id}/partidas/{partidaId}/eventos")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Evento> insertEventos(@PathVariable Long partidaId, @RequestBody Evento obj) {
		return new ResponseEntity<>(es.insert(partidaId, obj), HttpStatus.CREATED);
	}
	
	@RequestMapping(value ="/{torneioId}/partidas")
	public ResponseEntity<Partida> insertPartida(@PathVariable Long torneioId, @RequestBody Partida obj) {
		Torneio torneio = ts.findById(torneioId);
		obj.setTorneio(torneio);
		return new ResponseEntity<>(ts.insertPartidaInTorneio(obj), HttpStatus.CREATED);
	}
	
	@PutMapping
	public Torneio update(@RequestBody Torneio obj) {
		return ts.update(obj);
	}

}
