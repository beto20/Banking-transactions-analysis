package com.alberto.transactions.service;

import com.alberto.transactions.model.CreditCardDto;
import com.alberto.transactions.model.LoanDto;
import com.alberto.transactions.publisher.PublisherTransaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.UUID;

@Service
@Qualifier("loan-service")
public class LoanServiceImpl implements TransactionService {
    Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);

    private Boolean IS_ACTIVE = Boolean.FALSE;
    @Qualifier("loan-publisher")
    private final PublisherTransaction publisherTransaction;

    public LoanServiceImpl(@Qualifier("loan-publisher") PublisherTransaction publisherTransaction) {
        this.publisherTransaction = publisherTransaction;
    }

    @Override
    public void initAsynchronousProcess(Boolean status) {
        IS_ACTIVE = status;
        int i = 0;
        while (IS_ACTIVE) {
            try {
                var data = generateLoanTx(i);
                publisherTransaction.publishMessage(data);
                i++;
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private String generateLoanTx(int iteration) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            var loanDtoArray = readDataFromJson();
            return mapper.writeValueAsString(loanDtoArray[iteration]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private LoanDto[] readDataFromJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            var loanArray = mapper.readValue(new File("src/main/resources/loan-mock-data.json"), LoanDto[].class);

            System.out.println(loanArray[0].getId());
            System.out.println(loanArray[1].getId());
            return loanArray;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private LoanDto dataMock() {
        var loanDto = new LoanDto();

        loanDto.setId(UUID.randomUUID().toString());
        loanDto.setName("Mario");
        loanDto.setMiddleName("Jesus");
        loanDto.setLastname("Perez");
        loanDto.setDocument("DNI");
        loanDto.setNumber("12345678");
        loanDto.setQualification("INVESTIGADO");

        loanDto.setAccountNumber("20394857612");
        loanDto.setDisbursementAmount("10000.00");
        loanDto.setDisbursementDate("23/07/2023");
        loanDto.setCurrency("PEN");
        loanDto.setTerm("10");
        loanDto.setQuota("1000");
        loanDto.setInterestRate("14.5");
        loanDto.setHasInsurance(Boolean.TRUE);
        loanDto.setStatus("Active");

        loanDto.setProduct("SEGURO_TARJETAS_360");
        loanDto.setPolicyNumber("123456");
        loanDto.setPaymentAmount("100");
        loanDto.setPaymentFrequency("MENSUAL");
        loanDto.setPaymentCurrency("PEN");

        loanDto.setProvince("Lima");
        loanDto.setAuthorizer("XT1234");

        return loanDto;
    }


}
