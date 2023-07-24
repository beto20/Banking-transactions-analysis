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

//		var transaction = new TransactionDto();
//
//		transaction.setId(UUID.randomUUID().toString());
//		transaction.setName("Mario");
//		transaction.setMiddleName("Jesus");
//		transaction.setLastname("Perez");
//		transaction.setMotherLastname("Luna");
//		transaction.setIdentity(new TransactionDto.Identity("DNI", "12345678"));
//		transaction.setTotalAmount("10000.00");
//		transaction.setDate("23/07/2023");
//		transaction.setCreditLine("100000.00");
//		transaction.setExpirationDate("10/2025");
//		transaction.setCardNumber("102938475612345");
//		transaction.setCardBrand("VISA");
//		transaction.setCardType("SIGNATURE");
//		transaction.setClientResult("INVESTIGADO");
//		transaction.setCurrency("PEN");
//
//		System.out.println("message:: " + transaction);
//
//
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writeValueAsString(transaction);
//		System.out.println("message Output JSON:: " + json);
//
//		byte[] bytes =json.getBytes(StandardCharsets.UTF_8);
//		System.out.println("message Output Bytes:: " + Arrays.toString(bytes));
//
//		var messageDecode = new String(bytes, StandardCharsets.UTF_8);
//		System.out.println("message Decode:: " + messageDecode);
//
//		TransactionDto tx = mapper.readValue(messageDecode, TransactionDto.class);
//		System.out.println("message Input TX STRING:: " + tx.toString());

	}

}
