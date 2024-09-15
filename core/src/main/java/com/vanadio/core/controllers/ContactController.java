package com.vanadio.core.controllers;

import com.vanadio.core.dtos.MessageDTO;
import com.vanadio.core.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@Valid @RequestBody MessageDTO messageDTO) {
        System.out.println(messageDTO.toString());
        emailService.sendEmail(messageDTO.getEmail(), messageDTO.getName(), messageDTO.getMessage());
        return new ResponseEntity<>("Email-ul a fost trimis", HttpStatus.OK);
    }

}
