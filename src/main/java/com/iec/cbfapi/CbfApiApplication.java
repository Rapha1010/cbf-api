package com.iec.cbfapi;

import com.iec.cbfapi.controllers.TorneioController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class CbfApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CbfApiApplication.class, args);
	}

}
