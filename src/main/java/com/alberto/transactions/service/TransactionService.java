package com.alberto.transactions.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface TransactionService {
    void initAsynchronousProcess(Boolean status) throws JsonProcessingException;
}
