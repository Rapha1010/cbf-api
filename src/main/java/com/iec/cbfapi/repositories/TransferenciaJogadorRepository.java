package com.iec.cbfapi.repositories;

import com.iec.cbfapi.entities.Time;
import com.iec.cbfapi.entities.TransferenciaJogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaJogadorRepository extends JpaRepository<TransferenciaJogador, Long> {
}
