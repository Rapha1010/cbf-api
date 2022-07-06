package com.iec.cbfapi.services;

import com.iec.cbfapi.entities.TransferenciaJogador;
import com.iec.cbfapi.repositories.TransferenciaJogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaJogadorService {

    @Autowired
    private TransferenciaJogadorRepository transferenciaJogadorRepository;

    @GetMapping
    public List<TransferenciaJogador> findAll() {
        return transferenciaJogadorRepository.findAll();
    }
    @GetMapping
    public TransferenciaJogador findById(Long id) {
        Optional<TransferenciaJogador> obj = transferenciaJogadorRepository.findById(id);
        return obj.get();
    }

}
