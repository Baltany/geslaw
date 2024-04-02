package com.geslaw.appgeslaw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerLogin {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Retorna el nombre de la página HTML del formulario de inicio de sesión
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Verifica las credenciales de inicio de sesión aquí
        // Si las credenciales son válidas, redirige a la página de inicio
        // Si las credenciales son inválidas, muestra un mensaje de error en el formulario de inicio de sesión

        return "redirect:/home"; // Redirige a la página de inicio después del inicio de sesión exitoso
    }
}
