package com.iec.cbfapi.controllers;

import com.iec.cbfapi.entities.Time;
import com.iec.cbfapi.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cfb-api/times")
public class TimeController {

    @Autowired
    private TimeService ts;

    @GetMapping
    public ResponseEntity<List<Time>> findAll() {
        List<Time> list = ts.findAll();
        return ResponseEntity.ok().body(list);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Time> findById(@PathVariable Long id) {
    	Time obj = ts.findById(id);
		return ResponseEntity.ok().body(obj);
    }
    
    @PostMapping
    public ResponseEntity<Time> insert(@RequestBody Time obj) {
    	Time time = ts.insert(obj);
		return ResponseEntity.ok().body(time);
    }
    
    @PutMapping
    public ResponseEntity<Time> update(@RequestBody Time obj) {
    	Time time = ts.update(obj);
		return ResponseEntity.ok().body(time);
    }

}
