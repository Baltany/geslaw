package com.geslaw.appgeslaw.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
 * ESTAN TODOS LOS CAMPOS EN MAYUSCULA
 */
@Data
@Entity
@NoArgsConstructor
public class AltaLaboral{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String apellido1sustituidoalta;

    private String apellido2sustituidoalta;

    private String distribucionhoraria;

    private String dnisustituidoalta;

    private Date fechainicioalta;

    private String horassemanales;

    private Integer jornadanormal;

    private String minutossemanales;

    private String nombresustituidosalta;

    private String observacionesalta;

    private Integer titular;

    private Integer categoriaprofesionalalta_id;

}