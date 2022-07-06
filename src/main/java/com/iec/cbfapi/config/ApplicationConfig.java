package com.iec.cbfapi.config;

import com.iec.cbfapi.entities.Time;
import com.iec.cbfapi.repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ApplicationConfig implements CommandLineRunner {

    @Autowired
    private TimeRepository tr;

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub

        Time time1 = new Time(null, "Flamengo","RJ");
        Time time2 = new Time(null, "Palmeiras", "SP");
        Time time3 = new Time(null, "Fluminense","RJ");

        tr.saveAll(Arrays.asList(time1, time2, time3));

    }

}