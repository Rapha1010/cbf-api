package com.iec.cbfapi.repositories;

import com.iec.cbfapi.entities.Jogador;
import com.iec.cbfapi.entities.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
}
