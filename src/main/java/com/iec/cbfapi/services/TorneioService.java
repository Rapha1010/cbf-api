package com.iec.cbfapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.iec.cbfapi.entities.Partida;
import com.iec.cbfapi.entities.Torneio;
import com.iec.cbfapi.repositories.PartidaRepository;
import com.iec.cbfapi.repositories.TorneioRepository;

@Service
public class TorneioService {
	
	@Autowired
	private TorneioRepository tr;
	
	@Autowired
	private PartidaRepository pr;
	
	public List<Torneio> findAll() {
		List<Torneio> list = tr.findAll();
		return list;
	}
	
	public Torneio findById(Long id) {	
		Optional<Torneio> obj = tr.findById(id);
		return obj.orElse(null);
	}
	
	public Torneio insert(Torneio obj) {
		return tr.save(obj);
	}
	
	public Torneio update(Torneio obj) {
		
		Torneio torneio = tr.getReferenceById(obj.getId());
		updateData(torneio, obj);
		return tr.save(torneio);
	}

	private void updateData(Torneio torneio, Torneio obj) {
		torneio.setNome(obj.getNome());
		torneio.setLocalDisputa(obj.getLocalDisputa());
		torneio.setOrganizacao(obj.getOrganizacao());	
	}
	
	public Partida insertPartidaInTorneio(Partida obj) {
		return pr.save(obj);
	}

}
