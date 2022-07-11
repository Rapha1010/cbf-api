package com.iec.cbfapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iec.cbfapi.entities.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
