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


/* @Data -> indicamos a spring que necesitamos getters y setters,por lo que los genera automáticamente
 * @Entity -> inidicamos a spring que es una clase entidad
 * @NoArgsConstructor -> no necesitamos los constructores,porque automáticamente los genera
 */
@Data
@Entity
@NoArgsConstructor
public class Sede {

    /*
     * Hace que cuando lanzamos spring y genere la base de datos automáticamente,detecte que este campo es un idy lo autoincremente
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Nombre de la sede o del centro? 
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
     * @ManyToMany -> Varias sedes tiene muchos tipos de sedes
     * Posible cambio a @OneToMany
     */
    @ManyToMany
    private List<TipoSede> tipoSede;

    private String tipoCentro;


    /*
     * @ManyToOne -> Un usuario tiene varias sedes
     */
    @ManyToOne
    private Usuario usuario; 


    /*
     *  @ManyToOne -> Varias empresas pertenecen a una unica sede
     */
    @ManyToOne
    private Empresa empresa;

    /*
     * @OneToOne -> Una factura es de una unica sede
     * @JoinColumn -> Se le añade el id a la tabla correspondiente
     */
    @OneToMany
    @JoinColumn(name = "sede_factura_id")
    private List<Factura> factura;


    private Boolean habilitar;

    /*
     * @OneToOne -> Una sede pertence a un unico territorio
     * @JoinColumn -> Se le añade el id a la tabla correspondiente
     */
    @OneToOne
    @JoinColumn(name = "sede_territorio_id")
    private Territorio territorio;


    @OneToOne
    @JoinColumn(name = "sede_obligado_cumplimiento_id")
    private ObligadoCumplimiento obligadoCumplimiento;

    
}
