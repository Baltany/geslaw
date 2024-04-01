package com.geslaw.appgeslaw.model;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Seguro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Tipo de seguro a que se refiere
     */

    private String fechaVencimiento;

    /*
     * Relacion Seguro-Sede/Usuario
     */


    @ManyToOne
    private Empresa empresa;
    
    private String fichero;

    private String observaciones;

    private Boolean aplica;

    
}
