package com.benkitoucoders.bankservice.dto;

import com.benkitoucoders.bankservice.entity.AccountInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankResponse {
    private String responseCode;
    private AccountInfo accountInfo;

}
