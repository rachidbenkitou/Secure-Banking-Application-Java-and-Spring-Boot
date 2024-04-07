package com.benkitoucoders.bankservice.service;

import com.benkitoucoders.bankservice.dto.EmailDetails;

public interface EmailService {
    void sendEmailAlert(EmailDetails emailDetails);
}
