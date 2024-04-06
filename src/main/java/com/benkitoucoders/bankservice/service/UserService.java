package com.benkitoucoders.bankservice.service;

import com.benkitoucoders.bankservice.dto.BankResponse;
import com.benkitoucoders.bankservice.dto.UserRequest;

public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
}
