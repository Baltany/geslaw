package com.geslaw.appgeslaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// import javax.mail.MessagingException;
// import javax.mail.internet.MimeMessage;

@Controller
@RequestMapping("/enviar-correo")
public class EmailController {
/*
    @Autowired
    private javaMailSender javaMailSender;

    @PostMapping
    @ResponseBody
    public String enviarCorreo(@RequestParam String nombre,
                               @RequestParam String telefono,
                               @RequestParam String asunto,
                               @RequestParam String email,
                               @RequestParam String mensaje) {

        String destinatario = "incidencias.ssii@macrosad.com";
        String cuerpoMensaje = "Nombre: " + nombre + "\nTeléfono: " + telefono + "\nEmail: " + email + "\nMensaje: " + mensaje;

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(destinatario);
            helper.setSubject(asunto);
            helper.setText(cuerpoMensaje);
            javaMailSender.send(message);
            return "Correo enviado correctamente";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error al enviar el correo";
        }
    }*/
}
