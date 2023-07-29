package com.alberto.transactions.service;

import com.alberto.transactions.model.CreditCardDto;
import com.alberto.transactions.publisher.PublisherTransaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
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
    public void initAsynchronousProcess(Boolean status) {
        IS_ACTIVE = status;
        int i = 0;
        while (IS_ACTIVE) {
            try {
                var data = generateCreditCardTx(i);
                publisherTransaction.publishMessage(data);
                i++;
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    private String generateCreditCardTx(int iteration) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            var creditCardDtoArray = readDataFromJson();
            return mapper.writeValueAsString(creditCardDtoArray[iteration]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private CreditCardDto[] readDataFromJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            var creditCardArray = mapper.readValue(new File("src/main/resources/credit-card-mock-data.json"), CreditCardDto[].class);

            System.out.println(creditCardArray[0].getId());
            System.out.println(creditCardArray[1].getId());
            return creditCardArray;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private CreditCardDto dataMock() {
        var creditCardDto = new CreditCardDto();

        creditCardDto.setId(UUID.randomUUID().toString());
        creditCardDto.setName("Mario");
        creditCardDto.setMiddleName("Jesus");
        creditCardDto.setLastname("Perez");
        creditCardDto.setDocument("DNI");
        creditCardDto.setNumber("12345678");
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

        creditCardDto.setProduct("SEGURO_TARJETAS_360");
        creditCardDto.setPolicyNumber("123456");
        creditCardDto.setPaymentAmount("100");
        creditCardDto.setPaymentFrequency("MENSUAL");
        creditCardDto.setPaymentCurrency("PEN");

        creditCardDto.setStore("Ripley");
        creditCardDto.setProvince("Lima");

        return creditCardDto;
    }

}
