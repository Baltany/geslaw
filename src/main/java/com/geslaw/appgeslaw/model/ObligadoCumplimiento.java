package com.geslaw.appgeslaw.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
/*
 * ComunAbstractLaw
 */
public class ObligadoCumplimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Tipo obligado cumplimiento
     */

    private String fechaValidez;


    @OneToOne
    private Territorio territorio;

    
    @OneToOne
    private Sede sede;

    
    @OneToOne
    private Usuario usuario;

    @ManyToOne
    private Empresa empresa;


    private String fichero;

    private String observaciones;

    private Boolean aplica;

    private Boolean favorable;

    private Boolean borrar;
    

}
