package com.geslaw.appgeslaw.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@NoArgsConstructor
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Nombre de la sede
     */
    private String nombre;

    private String direccion;

    private String localidad;

    private String provincia;

    /*
     * Se podría poner perfectamente como Integer pero para evitar que 
     * algun cliente o cualquier otro tipo de usuario pueda meter +34 o cualquier digito que indique otro pais
     */
    private String telefono;


    /*
     * Codigo postal
     */
    private String cp;


    /*
     * tipoSede:id y nombre;
     * el nombre nombre del centro
     */
    private List<TipoSede> tipoSede;
}
