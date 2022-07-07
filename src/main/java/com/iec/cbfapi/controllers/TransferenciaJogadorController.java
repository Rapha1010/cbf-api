package com.iec.cbfapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iec.cbfapi.entities.TransferenciaJogador;
import com.iec.cbfapi.services.TransferenciaJogadorService;

@RestController
@RequestMapping(value = "/cfb-api/transferencia-jogador")
public class TransferenciaJogadorController {
	
	@Autowired
	private TransferenciaJogadorService tjs;
	
	@GetMapping
	public ResponseEntity<List<TransferenciaJogador>> findAll() {
		List<TransferenciaJogador> list = tjs.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TransferenciaJogador> findById(@PathVariable Long id) {
		TransferenciaJogador obj = tjs.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<TransferenciaJogador> insert(@RequestBody TransferenciaJogador obj) {
		TransferenciaJogador transf = tjs.insert(obj);
		return ResponseEntity.ok().body(transf);
	}

}
