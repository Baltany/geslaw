package com.geslaw.appgeslaw.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
/*Preguntar que es facturasN o si lo necesito */
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    /*
     * Se guarda el nombre del proveedor por eso no se necesita una clase aparte
     */
    private String proveedor;


    /*
     * Una factura es de una unica sede
     */
    @OneToOne
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