package com.benkitoucoders.bankservice.service;

import com.benkitoucoders.bankservice.dto.TransactionDto;
import com.benkitoucoders.bankservice.entity.Transaction;

public interface TransactionService {
    void saveTransaction(TransactionDto transactionDto);
}
