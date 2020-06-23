package com.cognizant.moviecruiser;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cognizant.moviecruiser.controller,com.cognizant.moviecruiser.service,com.cognizant.moviecruiser.dao,com.cognizant.moviecruiser,com.cognizant.moviecruiser.exception")
@EnableDiscoveryClient
public class MovieCruiserApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieCruiserApplication.class);
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(MovieCruiserApplication.class, args);
	}

}
