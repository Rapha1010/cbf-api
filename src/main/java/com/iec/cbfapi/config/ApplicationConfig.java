package com.iec.cbfapi.config;

import com.iec.cbfapi.entities.*;
import com.iec.cbfapi.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@EnableRedisRepositories
public class ApplicationConfig implements CommandLineRunner {

    @Autowired
    private TimeRepository tr;
    
    @Autowired
    private JogadorRepository jr;
    
    @Autowired
    private TransferenciaJogadorRepository tjr;
    
    @Autowired
    private TorneioRepository tnr;

    @Autowired
    private TimeTorneioRepository ttr;
    
    @Autowired
    private PartidaRepository prr;
    
    @Autowired
    private EventoRepository err;
    
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

        TimeTorneio tt1 = new TimeTorneio(null, time1, tn1);
        TimeTorneio tt2 = new TimeTorneio(null, time2, tn1);
        TimeTorneio tt3 = new TimeTorneio(null, time3, tn1);
        TimeTorneio tt4 = new TimeTorneio(null, time4, tn1);

        ttr.saveAll(Arrays.asList(tt1, tt2, tt3, tt4));
        
       
        Partida pt1 = new Partida(null,Instant.parse("2022-12-19T19:00:00Z"),null, null, time1,time2, tn1);
        Partida pt2 = new Partida(null,Instant.parse("2022-12-21T19:00:00Z"),null, null, time3,time5, tn1);
        Partida pt3 = new Partida(null,Instant.parse("2022-12-22T19:00:00Z"),null, null, time4,time2, tn1);
        
        Partida pt4 = new Partida(null,Instant.parse("2022-12-19T19:00:00Z"),null, null, time1,time5, tn2);
        Partida pt5 = new Partida(null,Instant.parse("2022-12-21T19:00:00Z"),null, null, time3,time4, tn2);
        Partida pt6 = new Partida(null,Instant.parse("2022-12-22T19:00:00Z"),null, null, time4,time2, tn2);
        
        
        prr.saveAll(Arrays.asList(pt1,pt3,pt2,pt4,pt5,pt6));
        
        Evento ev1 = new Evento(null, "gol", pt1);
        Evento ev2 = new Evento(null, "cartao vermelho", pt1);
        Evento ev3 = new Evento(null, "falta", pt1);
        Evento ev5 = new Evento(null, "impedimento", pt1);
        Evento ev6 = new Evento(null, "penalte", pt1);
        
        err.saveAll(Arrays.asList(ev1,ev2,ev3,ev5,ev6));

    }

    @Bean
    public JedisConnectionFactory connectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName("localhost");
        configuration.setPort(6379);
        return new JedisConnectionFactory(configuration);
    }

    @Bean
    public RedisTemplate<String, Object> template() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new JdkSerializationRedisSerializer());
        template.setValueSerializer(new JdkSerializationRedisSerializer());
        template.setEnableTransactionSupport(true);
        template.afterPropertiesSet();
        return template;
    }


}