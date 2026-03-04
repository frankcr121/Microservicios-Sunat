package com.sunat.recepcion.validador_comprobantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
public class ValidadorComprobantesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidadorComprobantesApplication.class, args);
	}
}