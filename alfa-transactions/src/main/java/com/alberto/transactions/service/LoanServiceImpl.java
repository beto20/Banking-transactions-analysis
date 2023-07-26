package com.alberto.transactions.service;

import com.alberto.transactions.model.IdentityDto;
import com.alberto.transactions.model.LoanDto;
import com.alberto.transactions.publisher.PublisherTransaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
    public void initAsynchronousProcess(Boolean status) throws JsonProcessingException {
        IS_ACTIVE = status;
        while (IS_ACTIVE) {
            try {
                var data = generateLoanTx();
                publisherTransaction.publishMessage(data);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private String generateLoanTx() throws JsonProcessingException {
        var loanDto = new LoanDto();

        loanDto.setId(UUID.randomUUID().toString());
        loanDto.setName("Mario");
        loanDto.setMiddleName("Jesus");
        loanDto.setLastname("Perez");
        loanDto.setMotherLastname("Luna");
        loanDto.setIdentity(new IdentityDto("DNI", "12345678"));
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

        loanDto.setStore("Centro civico");
        loanDto.setProvince("Lima");
        loanDto.setAuthorizer("XT1234");

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(loanDto);
    }

}
