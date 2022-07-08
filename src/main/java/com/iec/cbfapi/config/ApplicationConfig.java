package com.iec.cbfapi.config;

import com.iec.cbfapi.entities.Jogador;
import com.iec.cbfapi.entities.Time;
import com.iec.cbfapi.entities.Torneio;
import com.iec.cbfapi.entities.TransferenciaJogador;
import com.iec.cbfapi.repositories.JogadorRepository;
import com.iec.cbfapi.repositories.TimeRepository;
import com.iec.cbfapi.repositories.TorneioRepository;
import com.iec.cbfapi.repositories.TransferenciaJogadorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

@Configuration
public class ApplicationConfig implements CommandLineRunner {

    @Autowired
    private TimeRepository tr;
    
    @Autowired
    private JogadorRepository jr;
    
    @Autowired
    private TransferenciaJogadorRepository tjr;
    
    @Autowired
    private TorneioRepository tnr;


    @Override
    public void run(String... args) throws Exception {

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
        
        TransferenciaJogador tj1 = new TransferenciaJogador(null,jd1,time1,time5,20000);
        TransferenciaJogador tj2 = new TransferenciaJogador(null,jd2,time4,time2,20000);
        TransferenciaJogador tj3 = new TransferenciaJogador(null,jd3,time5,time4,20000);
        
        tjr.saveAll(Arrays.asList(tj1, tj2, tj3));
        
        Torneio tn1 = new Torneio(null, "Libertadores", "América do Sul", "CONMEBOL");
        Torneio tn2 = new Torneio(null, "Brasileirão", "Brasil", "CBF");
        Torneio tn3 = new Torneio(null, "Copa do Brasil", "Brasil", "CBF");
        
        tnr.saveAll(Arrays.asList(tn1, tn2, tn3));
        

    }

}