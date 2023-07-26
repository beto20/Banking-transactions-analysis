package com.alberto.transactions.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface TransactionService {
    void initAsynchronousProcess(String status) throws JsonProcessingException;
}
