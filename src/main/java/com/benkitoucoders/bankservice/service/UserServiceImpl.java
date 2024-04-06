package com.benkitoucoders.bankservice.service;

import com.benkitoucoders.bankservice.dto.BankResponse;
import com.benkitoucoders.bankservice.dto.UserRequest;
import com.benkitoucoders.bankservice.entity.User;
import com.benkitoucoders.bankservice.utils.AccountUtils;

public class UserServiceImpl implements UserService {
    @Override
    public BankResponse createAccount(UserRequest userRequest) {
        User newUser = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .otherName(userRequest.getOtherName())
                .gender(userRequest.getGender())
                .address(userRequest.getAddress())
                .stateOfOrigin(userRequest.getStateOfOrigin())
                .accountNumber(AccountUtils.generateAccountNumber())
                .build();
        return null;
    }
}
