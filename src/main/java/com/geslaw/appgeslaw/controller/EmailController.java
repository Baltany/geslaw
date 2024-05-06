package com.geslaw.appgeslaw.controller;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;



@RestController
@RequestMapping("/correo")
public class EmailController {
    
    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/enviar")
    public String enviarCorreo(@RequestBody String[] destinatarios,@RequestBody String asunto,@RequestBody String mensaje) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(destinatarios);
            mailMessage.setSubject(asunto);
            mailMessage.setText(mensaje);

            mailSender.send(mailMessage);

            return "Correo enviado correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al enviar el correo";
        }
    }

    // public JavaMailSender getJavaMailSender(){
    //     JavaMailSender mailSender = new JavaMailSenderImpl();

    //     Properties props = new Properties();
    //     props.put("mail.transport.protocol", "smtp");
    //     props.put("mail.smtp.auth", "true");
    //     props.put("mail.smtp.starttls.enable", "true");
    //     props.put("mail.debug", "true");

    //     return mailSender;

    // }


}
