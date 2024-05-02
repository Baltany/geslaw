package com.geslaw.appgeslaw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerPrincipal {

    
    @GetMapping("/acerca")
    public String showAcerca() {
        return "acerca";
    }

    @GetMapping("/error")
    public String showError() {
        return "error";
    }

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @GetMapping("/ayuda")
    public String mostrarAyuda() {
        return "ayuda";
    }


    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }
    
    // @GetMapping("/register")
    // public String showRegister() {
    //     return "register";
    // }

    /*Si el usuario no tiene los permisos necesarios,lo redirigimos aquí */
    @GetMapping("/denegado")
    public String showDenegado() {
        return "denegado";
    }

}
