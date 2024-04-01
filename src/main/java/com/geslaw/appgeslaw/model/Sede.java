package com.geslaw.appgeslaw.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
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
     * el nombre del centro
     */
    @ManyToMany
    private List<TipoSede> tipoSede;

    private String tipoCentro;


    /*
     * Recoge el id del usuario
     */
    @ManyToOne
    private Usuario usuario; 


    /*
     * Una empresa tiene varias sedes
     */
    @ManyToOne
    private Empresa empresa;

    @OneToOne
    @JoinColumn(name = "sede_factura_id")
    private Factura factura;

    /*
     * TipoCentro
     */

    private Boolean habilitar;

    /*
     * idTerritorio
     */
    @OneToOne
    @JoinColumn(name = "sede_territorio_id")
    private Territorio territorio;
}
