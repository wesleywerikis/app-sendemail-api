package br.com.weswerikis.controller;

import br.com.weswerikis.dto.EmailDto;
import br.com.weswerikis.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailDto emailRequest) throws MessagingException {
        try {
            emailService.sendEmail(
                    emailRequest.getTo(),
                    emailRequest.getSubject(),
                    emailRequest.getName(),
                    emailRequest.getMessage()
            );
            return "E-mail enviado com sucesso!";
        } catch (MessagingException | UnsupportedEncodingException e) {
            return "Falha ao enviar e-mail: " + e.getMessage();
        }
    }
}