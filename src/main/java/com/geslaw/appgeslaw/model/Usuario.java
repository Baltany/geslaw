package com.geslaw.appgeslaw.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /*
     * Formulario en que el usuario pueda añadir sus dos 
     * apellido automáticamente
     */
    private String apellidos;

    private String dni;

    private String email;

    private String password;

    @ManyToMany
    private List<TipoUsuario> tipoUsuario;
    
    /*
     * Cada usuario puede tener DEPENDIENDO del usuario una única sede o varias
     * Usuario puede tener varias sedes,desde ahi 
     * accedemos mediante una consulta a usuarios_sede.tiposede == "sede"
     */
    @ManyToMany
    private List<Sede> sede;
    








}