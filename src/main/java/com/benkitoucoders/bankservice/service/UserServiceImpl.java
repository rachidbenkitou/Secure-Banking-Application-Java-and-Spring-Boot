package com.benkitoucoders.bankservice.service;

import com.benkitoucoders.bankservice.dto.BankResponse;
import com.benkitoucoders.bankservice.dto.EmailDetails;
import com.benkitoucoders.bankservice.dto.UserRequest;
import com.benkitoucoders.bankservice.entity.AccountInfo;
import com.benkitoucoders.bankservice.entity.User;
import com.benkitoucoders.bankservice.repository.UserRepository;
import com.benkitoucoders.bankservice.utils.AccountUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final EmailService emailService;

    /**
     * Creating an account - saving a new user into the db
     * check if user already has an account
     */
    @Override
    public BankResponse createAccount(UserRequest userRequest) {
        if (Boolean.TRUE.equals(userRepository.existsByEmail(userRequest.getEmail()))) {
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                    .accountInfo(null)
                    .build();
        }

        User newUser = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .otherName(userRequest.getOtherName())
                .gender(userRequest.getGender())
                .address(userRequest.getAddress())
                .stateOfOrigin(userRequest.getStateOfOrigin())
                .accountNumber(AccountUtils.generateAccountNumber())
                .accountBalance(BigDecimal.ZERO)
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .status("ACTIVE")
                .build();
        User savedUser = userRepository.save(newUser);
        // Send Email Alter
        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(savedUser.getEmail())
                .subject("ACCOUNT CREATION")
                .messageBody("Congratulations! your account has been successfully created.\nYour Account Details: \n " +
                        "Account Name: " + savedUser.getFirstName() + " " + savedUser.getLastName() + " " + savedUser.getOtherName() + "\n" +
                        "Account Number: " + savedUser.getAccountNumber())
                .build();
        emailService.sendEmailAlert(emailDetails);
        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS)
                .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountBalance(savedUser.getAccountBalance())
                        .accountNumber(savedUser.getAccountNumber())
                        .accountName(savedUser.getFirstName() + " " + savedUser.getLastName() + " " + savedUser.getOtherName())
                        .build())
                .build();
    }
}
