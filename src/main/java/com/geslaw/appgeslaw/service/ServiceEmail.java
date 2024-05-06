package com.geslaw.appgeslaw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.geslaw.appgeslaw.repo.RepoEmail;

public class ServiceEmail implements RepoEmail{
    
    @Value("${email.dominio}")
    private String email;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String[] enviador, String asunto, String mensaje) {
        // TODO Auto-generated method stub
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(email);
        mailMessage.setTo(enviador);
        mailMessage.setSubject(asunto);
        mailMessage.setText(mensaje);

        mailSender.send(mailMessage);
    }
}
