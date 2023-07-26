package com.alberto.transactions.service;

import com.alberto.transactions.model.CreditCardDto;
import com.alberto.transactions.model.IdentityDto;
import com.alberto.transactions.publisher.PublisherTransaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Qualifier("credit-card-service")
public class CreditCardServiceImpl implements TransactionService {
    private Boolean IS_ACTIVE = Boolean.FALSE;
    @Qualifier("credit-card-publisher")
    private final PublisherTransaction publisherTransaction;

    public CreditCardServiceImpl(@Qualifier("credit-card-publisher") PublisherTransaction publisherTransaction) {
        this.publisherTransaction = publisherTransaction;
    }

    @Override
    public void initAsynchronousProcess(Boolean status) throws JsonProcessingException {
        IS_ACTIVE = status;
        while (IS_ACTIVE) {
            try {
                var data = generateCreditCardTx();
                publisherTransaction.publishMessage(data);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    private String generateCreditCardTx() throws JsonProcessingException {
        var creditCardDto = new CreditCardDto();

        creditCardDto.setId(UUID.randomUUID().toString());
        creditCardDto.setName("Mario");
        creditCardDto.setMiddleName("Jesus");
        creditCardDto.setLastname("Perez");
        creditCardDto.setMotherLastname("Luna");
        creditCardDto.setIdentity(new IdentityDto("DNI", "12345678"));
        creditCardDto.setQualification("INVESTIGADO");

        creditCardDto.setCreditLine("100000.00");
        creditCardDto.setCardExpiration("10/25");
        creditCardDto.setCardNumber("102938475612345");
        creditCardDto.setCardBrand("VISA");
        creditCardDto.setCardType("SIGNATURE");
        creditCardDto.setDisbursementAmount("6500.00");
        creditCardDto.setDisbursementDate("25/07/2023");
        creditCardDto.setCurrency("PEN");
        creditCardDto.setHasInsurance(Boolean.TRUE);
        creditCardDto.setStatus("Active");

        creditCardDto.setStore("Ripley");
        creditCardDto.setProvince("Lima");

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(creditCardDto);
    }


}
