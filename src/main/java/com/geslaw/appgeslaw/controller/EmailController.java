package com.geslaw.appgeslaw.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
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

import com.geslaw.appgeslaw.domain.EmailDTO;
import com.geslaw.appgeslaw.service.ServiceEmail;




@RestController
@RequestMapping("/correo")
public class EmailController {

    @Autowired
    private ServiceEmail emailService;

    @PostMapping("/enviar")
    public ResponseEntity<?> receiveRequestEmail(@RequestBody EmailDTO emailDTO){

        System.out.println("Mensaje recibido: "+ emailDTO);

        emailService.sendEmail(emailDTO.getDestinatario(), emailDTO.getAsunto(), emailDTO.getMensaje());
        Map<String,String> response = new HashMap<>();
        response.put("estado","Enviado");

        return (ResponseEntity<?>) ResponseEntity.ok(response);
    }
    


}
