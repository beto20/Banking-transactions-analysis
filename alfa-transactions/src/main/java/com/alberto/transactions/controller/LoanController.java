package com.alberto.transactions.controller;


import com.alberto.transactions.service.TransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/transactions")
public class LoanController {

    @Qualifier("loan-service")
    private final TransactionService transactionService;

    public LoanController(@Qualifier("loan-service") TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("loan/{status}")
    public void startLoanTransactions(@PathVariable("Status") Boolean status) {
        transactionService.initAsynchronousProcess(status);
    }
}
