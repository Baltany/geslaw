package com.geslaw.appgeslaw.model;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;


/* @Data -> indicamos a spring que necesitamos getters y setters,por lo que los genera automáticamente
 * @Entity -> inidicamos a spring que es una clase entidad
 * @NoArgsConstructor -> no necesitamos los constructores,porque automáticamente los genera
 */
@Data
@Entity
@NoArgsConstructor
public class ObligadoCumplimiento {

    /*
     * Hace que cuando lanzamos spring y genere la base de datos automáticamente,detecte que este campo es un idy lo autoincremente
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Tipo obligado cumplimiento(contrato,seguro,autorizacion)
     */
    private String tipo;

    private String fechaValidez;


    /* @OneToOne -> Un ObligadoCumplimiento pertenece a un unico territorio */
    @OneToOne
    private Territorio territorio;

    /* @OneToOne -> Un ObligadoCumplimiento pertenece a una unica sede */
    @OneToOne
    private Sede sede;

    /* @OneToOne -> Un ObligadoCumplimiento pertenece a un unico usuario */    
    // @OneToOne
    // private Usuario usuario;

    /* @ManyToOne -> VARIOS Obligados Cumplimientos tiene una unica Empresa */
    @ManyToOne
    private Empresa empresa;


    @Transient
    private MultipartFile fichero;
    // private String fichero;

    private String observaciones;

    private Boolean aplica;

    private Boolean favorable;


    // private Boolean borrar;
    

}
