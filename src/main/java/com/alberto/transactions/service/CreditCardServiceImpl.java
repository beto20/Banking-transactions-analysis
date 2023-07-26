package com.alberto.transactions.service;

import com.alberto.transactions.model.TransactionDto;
import com.alberto.transactions.publisher.PublisherTransaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Qualifier("credit-card-service")
public class CreditCardServiceImpl implements TransactionService {
    Logger logger = LoggerFactory.getLogger(CreditCardServiceImpl.class);

    @Qualifier("credit-card-publisher")
    private final PublisherTransaction publisherTransaction;

    public CreditCardServiceImpl(@Qualifier("credit-card-publisher") PublisherTransaction publisherTransaction) {
        this.publisherTransaction = publisherTransaction;
    }

    @Override
    public void initAsynchronousProcess(String status) throws JsonProcessingException {
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

        publisherTransaction.publishMessage(json);
    }



}
