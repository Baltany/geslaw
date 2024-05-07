package com.geslaw.appgeslaw.model;

import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Factura {

    /*
     * Hace que cuando lanzamos spring y genere la base de datos automáticamente,detecte que este campo es un idy lo autoincremente
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    /*
     * Se guarda el nombre del proveedor por eso no se necesita una clase aparte
     */
    private String proveedor;

    @Transient
    private MultipartFile file;

    
    private String fichero;




    /*
     * @OneToOne -> Una factura es de una unica sede
     */
    @ManyToOne
    private Sede sede;

    private Boolean estado;

    private String observaciones;

    private Boolean visto;


    /*
     * Unicamente he metido la fecha validez ya que la fecha inicio y 
     * fechaVi no hacen falta si lo unico verdaderamente importante es cuando cumple
     */
    private String fechaVa;

    private String concepto;

    @ManyToOne
    private Usuario usuario;



}
