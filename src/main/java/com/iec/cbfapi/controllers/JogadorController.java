package com.iec.cbfapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iec.cbfapi.entities.Jogador;
import com.iec.cbfapi.services.JogadorService;

@RestController
@RequestMapping(value = "/cbf-api/jogadores")
public class JogadorController {
	
	@Autowired
	private JogadorService js;
	
	@GetMapping
	public ResponseEntity<List<Jogador>> findAll() {
		List<Jogador> list =  js.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Jogador> findById(@PathVariable Long id) {
		Jogador obj =  js.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Jogador> insert(@RequestBody Jogador obj) {
		Jogador jogador = js.insert(obj);
		return ResponseEntity.ok().body(jogador);
	}
	
	@PutMapping
	public ResponseEntity<Jogador> update(@RequestBody Jogador obj) {
		Jogador jogador = js.update(obj);
		return ResponseEntity.ok().body(jogador);
	}

}
