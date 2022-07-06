package com.iec.cbfapi.config;

import com.iec.cbfapi.entities.Jogador;
import com.iec.cbfapi.entities.Time;
import com.iec.cbfapi.repositories.JogadorRepository;
import com.iec.cbfapi.repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ApplicationConfig implements CommandLineRunner {

    @Autowired
    private TimeRepository tr;
    
    @Autowired
    private JogadorRepository jr;

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub

        Time time1 = new Time(null, "Flamengo","RJ");
        Time time2 = new Time(null, "Palmeiras", "SP");
        Time time3 = new Time(null, "Fluminense","RJ");
        Time time4 = new Time(null, "Vasco","RJ");
        Time time5 = new Time(null, "Santos","RJ");

        tr.saveAll(Arrays.asList(time1, time2, time3,time4, time5));
        
        Jogador jd1 = new Jogador(null, "Ronaldo","Brasil","22-12-76",time1);
        Jogador jd2 = new Jogador(null, "Romário","Brasil","22-12-76",time4);
        Jogador jd3 = new Jogador(null, "Neymar","Brasil","22-12-76",time5);
        
        jr.saveAll(Arrays.asList(jd1,jd2,jd3));
        
        

    }

}