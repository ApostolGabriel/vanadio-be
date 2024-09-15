package com.vanadio.core.services.impl;

import com.vanadio.core.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class DefaultEmailService implements EmailService {

    private static final String TO_EMAIL = "admin@vanadio.ro";
    private static final String SUBJECT = "Nume %s Email %s";

    private final JavaMailSender javaMailSender;

    @Autowired
    public DefaultEmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    @Async
    public void sendEmail(String from, String name, String body) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(TO_EMAIL);
        message.setSubject(String.format(SUBJECT, name, from));
        message.setText(body);

        javaMailSender.send(message);

    }

}
