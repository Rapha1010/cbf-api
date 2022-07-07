package com.iec.cbfapi.services;

import com.iec.cbfapi.entities.Jogador;
import com.iec.cbfapi.entities.TransferenciaJogador;
import com.iec.cbfapi.repositories.JogadorRepository;
import com.iec.cbfapi.repositories.TransferenciaJogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaJogadorService {

    @Autowired
    private TransferenciaJogadorRepository transferenciaJogadorRepository;
    
    @Autowired
    private JogadorRepository jogadorRepository;
    
    @Autowired
    private JogadorService jogadorService;

    @GetMapping
    public List<TransferenciaJogador> findAll() {
        return transferenciaJogadorRepository.findAll();
    }
    @GetMapping
    public TransferenciaJogador findById(Long id) {
        Optional<TransferenciaJogador> obj = transferenciaJogadorRepository.findById(id);
        return obj.get();
    }
    
    @PostMapping
    public TransferenciaJogador insert(TransferenciaJogador obj) {
    	
    	Jogador jogador = jogadorRepository.getReferenceById(obj.getJogador().getId());
    	updateData(jogador,obj);
    	jogadorService.update(jogador);
    	
    	return transferenciaJogadorRepository.save(obj);
    }
    
    private void updateData(Jogador jogador,TransferenciaJogador obj) {
    	jogador.setTime(obj.getTimeDestino());
    }

}
