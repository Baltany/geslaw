package com.geslaw.appgeslaw.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.geslaw.appgeslaw.model.Usuario;
import com.geslaw.appgeslaw.repo.RepoUsuario;



// @Service
public class ServiceUsuario {
    
    // @Autowired
    // RepoUsuario userRepo;

    // @Autowired
    // private PasswordEncoder passwordEncoder;

    // public void register(Usuario user) {
    //     // Verificar si el nombre de usuario ya está en uso
    //     if (userRepo.findByUsername(user.getUsername()) != null) {
    //         throw new RuntimeException("El nombre de usuario ya está en uso");
    //     }
        
    //     // Verificar si el correo electrónico ya está en uso
    //     if (userRepo.findByEmail(user.getEmail()) != null) {
    //         throw new RuntimeException("El correo electrónico ya está en uso");
    //     }

    //     // Codificar la contraseña antes de guardarla en la base de datos
    //     user.setPassword(passwordEncoder.encode(user.getPassword()));
    //     userRepo.save(user);
    // }

    // public boolean login(String username,String password){
    //         Usuario user = userRepo.findByUsername(username);
    //         if(user != null){
    //             return passwordEncoder.matches(password, user.getPassword());
    //         }
        
    //     return false;
    // }
}


