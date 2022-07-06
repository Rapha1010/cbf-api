package com.iec.cbfapi.services;

import com.iec.cbfapi.entities.Time;
import com.iec.cbfapi.repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public List<Time> findAll() {
        List<Time> list = timeRepository.findAll();
        return list;
    }

    public Time findById(Long id) {
        Optional<Time> obj = timeRepository.findById(id);
        return obj.get();
    }
    
    public Time insert(Time obj) {
    	return timeRepository.save(obj);
    }
    
    public Time update(Time obj) {
    	
    	Time time = timeRepository.getReferenceById(obj.getId());
    	UpdateData(time, obj);
    	return timeRepository.save(time);
    }
    
    public void UpdateData(Time time, Time obj) {
    	time.setNome(obj.getNome());
    	time.setUf(obj.getUf());
    }

}
