package com.benkitoucoders.bankservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AccountInfo {
    @Id
    private String accountName;
    private BigDecimal accountBalance;
    private String accountNumber;
}
