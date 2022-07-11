package com.iec.cbfapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iec.cbfapi.entities.Partida;
import com.iec.cbfapi.repositories.PartidaRepository;

@Service
public class PartidaService {
	
	@Autowired
	private PartidaRepository pr;
	
	public List<Partida> findAll() {
		List<Partida> list = pr.findAll();
		return list;
	}
	
	public Partida findById(Long id) {
		Optional<Partida> partida = pr.findById(id);
		return partida.get();
	}
	
	public Partida insert(Partida obj) {
		Partida partida = pr.save(obj);
		return partida;
	}
	
	public Partida update(Partida obj) {
		Partida partida = pr.getReferenceById(obj.getId());
		updateData(partida, obj);
		return pr.save(partida);
	}

	private void updateData(Partida partida, Partida obj) {
		partida.setPlacarMandante(obj.getPlacarMandante());
		partida.setPlacarVisitante(obj.getPlacarVisitante());
		partida.setTimeMandante(obj.getTimeMandante());
		partida.setTimeVisitante(obj.getTimeVisitante());
		partida.setTorneio(obj.getTorneio());
		partida.setDataHora(obj.getDataHora());
	}

}
