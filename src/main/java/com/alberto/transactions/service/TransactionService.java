package com.alberto.transactions.service;

import com.alberto.transactions.TransactionDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.UUID;

@Service
public class TransactionService {
    Logger logger = LoggerFactory.getLogger(TransactionService.class);
    @Value("${kafka-topic-name}")
    private String topicName;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public TransactionService(KafkaTemplate<String, Object> kafka) {
        this.kafkaTemplate = kafka;
    }

    public void initAsynchronousProcess() throws JsonProcessingException {
        var transaction = new TransactionDto();

        transaction.setId(UUID.randomUUID().toString());
        transaction.setName("Mario");
        transaction.setMiddleName("Jesus");
        transaction.setLastname("Perez");
        transaction.setMotherLastname("Luna");
        transaction.setIdentity(new TransactionDto.Identity("DNI", "12345678"));
        transaction.setTotalAmount("10000.00");
        transaction.setDate("23/07/2023");
        transaction.setCreditLine("100000.00");
        transaction.setExpirationDate("10/2025");
        transaction.setCardNumber("102938475612345");
        transaction.setCardBrand("VISA");
        transaction.setCardType("SIGNATURE");
        transaction.setClientResult("INVESTIGADO");
        transaction.setCurrency("PEN");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(transaction);

        this.publishMessage(json);
    }

    private void publishMessage(String message) {
        logger.info("Message:: {}, topic:: {}", message, topicName);

        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
        System.out.println("message Output Bytes:: " + Arrays.toString(bytes));

        var process = kafkaTemplate.send(topicName, bytes);

        process.completable().whenComplete((result, exception) -> {
            if (exception == null) logger.info("Message send successfully, offset {}", result.getRecordMetadata().offset());
            else logger.error("Message send failed, offset {}", result.getRecordMetadata());
        });
    }

}
