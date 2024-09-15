package com.vanadio.core.services;

public interface EmailService {

    void sendEmail(String from, String name, String body);

}
