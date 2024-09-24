package br.com.weswerikis.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.UnsupportedEncodingException;


@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void sendEmail(String to, String subject, String name, String messageContent) throws MessagingException, UnsupportedEncodingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        helper.setTo(to);
        helper.setFrom("seu-email@gmail.com", "SISTEMA DE SOFTWARE");
        helper.setSubject(subject);

        Context context = new Context();
        context.setVariable("name", name);
        context.setVariable("message", messageContent);

        String htmlContent = templateEngine.process("emailTemplate", context);
        helper.setText(htmlContent, true);

        mailSender.send(mimeMessage);
    }
}
