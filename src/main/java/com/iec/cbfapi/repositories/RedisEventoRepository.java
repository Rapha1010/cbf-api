package com.iec.cbfapi.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.iec.cbfapi.entities.RedisEvento;

@Repository
public class RedisEventoRepository {
	
	public static final String HASH_KEY = "Evento";
    @Autowired
    private RedisTemplate template;

    public RedisEvento save(String hashKey, @RequestBody RedisEvento evento){    	
        template.opsForHash().put(hashKey,evento.getId(),evento);
        return evento;
    }

    public List<RedisEvento> findAll(String hashKey){
        return template.opsForHash().values(hashKey);
    }

    public RedisEvento findEventoById(int id){
        return (RedisEvento) template.opsForHash().get(HASH_KEY,id);
    }


    public String deleteEvento(int id){
         template.opsForHash().delete(HASH_KEY,id);
        return "Evento removed !!";
    }


}
