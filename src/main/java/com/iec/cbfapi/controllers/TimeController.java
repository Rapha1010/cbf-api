package com.iec.cbfapi.controllers;

import com.iec.cbfapi.entities.Time;
import com.iec.cbfapi.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/time")
public class TimeController {

    @Autowired
    private TimeService ts;

    @GetMapping
    public ResponseEntity<List<Time>> findAll() {
        List<Time> list = ts.findAll();
        return ResponseEntity.ok().body(list);
    }

}
