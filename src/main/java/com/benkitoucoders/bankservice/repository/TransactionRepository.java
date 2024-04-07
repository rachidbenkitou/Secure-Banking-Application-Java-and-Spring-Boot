package com.benkitoucoders.bankservice.repository;

import com.benkitoucoders.bankservice.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
