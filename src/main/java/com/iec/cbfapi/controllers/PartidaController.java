package com.iec.cbfapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iec.cbfapi.entities.Partida;
import com.iec.cbfapi.services.PartidaService;

@RestController
@RequestMapping(value = "/cbf-api/partidas")
public class PartidaController {
	
	@Autowired
	private PartidaService ps;
	
	@GetMapping
	public ResponseEntity<List<Partida>> findAll() {
		List<Partida> list = ps.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Partida> findById(Long id) {
		Partida partida = ps.findById(id);
		return ResponseEntity.ok().body(partida);
	}
	
	@PostMapping
	public ResponseEntity<Partida> insert(Partida obj) {
		Partida partida = ps.insert(obj);
		return ResponseEntity.ok().body(partida);
	}
	
	@PutMapping
	public ResponseEntity<Partida> update(Partida obj) {
		Partida partida = ps.update(obj);
		return ResponseEntity.ok().body(partida);
	}

}
