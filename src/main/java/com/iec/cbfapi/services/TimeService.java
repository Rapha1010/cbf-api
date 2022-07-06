package com.iec.cbfapi.services;

import com.iec.cbfapi.entities.Time;
import com.iec.cbfapi.repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    @GetMapping
    public List<Time> findAll() {
        List list = timeRepository.findAll();
        return list;
    }

    @GetMapping
    public Time findBy(Long id) {
        Optional<Time> obj = timeRepository.findById(id);
        return obj.get();
    }


}
