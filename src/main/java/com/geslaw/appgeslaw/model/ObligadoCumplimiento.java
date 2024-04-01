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


    /*
     * Que tipo de relacion es
     */
    private Territorio territorio;


    private String fichero;

    private String observaciones;

    private Boolean aplica;

    private Boolean favorable;

    private Boolean borrar;
    

}
