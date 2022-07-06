package com.iec.cbfapi.services;

import com.iec.cbfapi.entities.Jogador;
import com.iec.cbfapi.entities.Time;
import com.iec.cbfapi.repositories.JogadorRepository;
import com.iec.cbfapi.repositories.TimeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;
    
    @Autowired
    private TimeRepository timeRepository;

    public List<Jogador> findAll() {
        return jogadorRepository.findAll();
    }
    
    public Jogador findById(Long id) {
        Optional<Jogador> obj = jogadorRepository.findById(id);
        return obj.get();
    }
    
    public Jogador insert(Jogador obj){
    	return jogadorRepository.save(obj);
    }
    
    public Jogador update(Jogador obj) {
    	
    	Jogador jogador = jogadorRepository.getReferenceById(obj.getId());
    	updateData(jogador, obj);
    	return jogadorRepository.save(jogador);
    }
    
    public void updateData(Jogador jogador, Jogador obj) {
    	
    	jogador.setNome(obj.getNome());
    	jogador.setPais(obj.getPais());
    	jogador.setDataNascimento(obj.getDataNascimento());
    	
    	Time time = timeRepository.getReferenceById(obj.getTime().getId());
    	jogador.setTime(time);
    	
    }

}
