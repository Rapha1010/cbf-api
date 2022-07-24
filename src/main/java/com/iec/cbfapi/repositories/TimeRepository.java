package com.iec.cbfapi.repositories;

import com.iec.cbfapi.entities.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TimeRepository extends JpaRepository<Time, Long> {
}
