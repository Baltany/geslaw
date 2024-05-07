package com.geslaw.appgeslaw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import com.geslaw.appgeslaw.repo.RepoEmail;

@Service
public class ServiceEmail implements RepoEmail{
    
    @Value("${spring.mail.username}")
    private String email;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String[] enviador, String asunto, String mensaje) {
        //TODO Auto-generated method stub
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        //dominio que manda el correo
        mailMessage.setFrom(email);
        //dominio que va a recibir el correo
        mailMessage.setTo("prueba.correo.spring.macrosad@gmail.com");
        mailMessage.setSubject(asunto);
        mailMessage.setText(mensaje);

        mailSender.send(mailMessage);
    }
}
