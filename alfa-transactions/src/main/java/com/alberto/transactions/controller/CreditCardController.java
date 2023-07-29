package com.alberto.transactions.controller;


import com.alberto.transactions.service.TransactionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/transactions")
public class CreditCardController {

    @Qualifier("credit-card-service")
    private final TransactionService transactionService;

    public CreditCardController(@Qualifier("credit-card-service") TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("credit-card/{status}")
    public void startCreditCardTransactions(@PathVariable("Status") Boolean status) {
        transactionService.initAsynchronousProcess(status);
    }



}
