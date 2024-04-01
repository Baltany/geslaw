package com.geslaw.appgeslaw.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Subcontrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Tipo de subcontrato preguntar que es
     */

    private String fechaVencimiento;

    /*
     * Relacion SubContrato - Empresa/Sede/Usuario
     */

    private String fichero;

    private String observaciones;

    private Boolean aplica;
    
}
