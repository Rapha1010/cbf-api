package com.iec.cbfapi.services;

import com.iec.cbfapi.entities.Jogador;
import com.iec.cbfapi.repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class JogadoreService {

    @Autowired
    private JogadorRepository jogadorRepository;

    @GetMapping
    public List<Jogador> findAll() {
        return jogadorRepository.findAll();
    }

    @GetMapping
    public Jogador findById(Long id) {
        Optional<Jogador> obj = jogadorRepository.findById(id);
        return obj.get();
    }

}
