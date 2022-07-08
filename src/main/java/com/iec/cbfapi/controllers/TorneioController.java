package com.iec.cbfapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iec.cbfapi.entities.Torneio;
import com.iec.cbfapi.services.TorneioService;

@RestController
@RequestMapping(value = "/cbf-api/torneios")
public class TorneioController {
	
	@Autowired
	private TorneioService ts;
	
	@GetMapping
	public List<Torneio> findAll() {
		List<Torneio> list = ts.findAll();
		return list;
	}
	
	@GetMapping(value = "/{id}")
	public Torneio findById(@PathVariable Long id) {
		Torneio torneio = ts.findById(id);
		return torneio;
	}
	
	@PostMapping
	public Torneio insert(@RequestBody Torneio obj) {
		return ts.insert(obj);
	}
	
	@PatchMapping
	public Torneio update(@RequestBody Torneio obj) {
		return ts.update(obj);
	}

}
