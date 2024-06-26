package com.geslaw.appgeslaw.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
public class Usuario {
    
    /*
     * Hace que cuando lanzamos spring y genere la base de datos automáticamente,detecte que este campo es un idy lo autoincremente
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /*
     * Formulario en que el usuario pueda añadir sus dos 
     * apellido automáticamente
     */

    private String username;

    private String nombre;

    private String apellidos;

    private String dni;

    private String email;

    private String password;

    private boolean habilitar;



    @ManyToMany
    private List<TipoUsuario> tipoUsuario;
    
    /*
     * Cada usuario puede tener DEPENDIENDO del usuario una única sede o varias
     * Usuario puede tener varias sedes,desde ahi 
     * accedemos mediante una consulta a usuarios_sede.tiposede == "sede"
     * 
     * Se relaciona cada usuario con la sede correspondiente
     */
    @OneToMany
    @JoinColumn(name = "usuario_sede_id")
    private List<Sede> sede;


    // @OneToOne
    // @JoinColumn(name = "usuario_obligado_cumplimiento_id")
    // private ObligadoCumplimiento obligadoCumplimiento;

    @OneToMany
    @JoinColumn(name = "usuario_facturas_id")
    private List<Factura> facturas;



}