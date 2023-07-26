package com.alberto.transactions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.UUID;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(Application.class, args);
	}

}
