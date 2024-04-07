package com.benkitoucoders.bankservice.service;

import com.benkitoucoders.bankservice.dto.EmailDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String senderEmail;

    @Override
    public void sendEmailAlert(EmailDetails emailDetails) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(senderEmail);
            mailMessage.setTo(emailDetails.getRecipient());
            mailMessage.setText(emailDetails.getMessageBody());
            mailMessage.setSubject(emailDetails.getSubject());

            javaMailSender.send(mailMessage);
            System.out.println("Mail sent successfully");

        } catch (Exception exception) {
            throw new RuntimeException();
        }
    }
}
