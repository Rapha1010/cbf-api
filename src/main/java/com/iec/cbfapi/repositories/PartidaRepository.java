package com.iec.cbfapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iec.cbfapi.entities.Partida;
import com.iec.cbfapi.entities.Torneio;

public interface PartidaRepository extends JpaRepository<Partida, Long>{
	
	List<Partida> findAllByTorneioId(Long torneioId);
	
	Partida findByIdAndTorneioId(Long id, Long partidaId);

}
