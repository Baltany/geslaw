package com.geslaw.appgeslaw.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;


/* @Data -> indicamos a spring que necesitamos getters y setters,por lo que los genera automáticamente
 * @Entity -> inidicamos a spring que es una clase entidad
 * @NoArgsConstructor -> no necesitamos los constructores,porque automáticamente los genera
 */
@Data
@Entity
@NoArgsConstructor
public class Territorio {

    /*
     * Hace que cuando lanzamos spring y genere la base de datos automáticamente,detecte que este campo es un idy lo autoincremente
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * DT1,DT2....
     */
    private String nombre;

    /* @OneToOne -> Un territorio pertenece a una unica sede */
    @OneToOne
    private Sede sede;

    /*
     * @OneToOne -> Un territorio tiene un unico obligado cumplimiento
     * @JoinColumn -> indicamos que la columna que se va a generar es la que se llama territorio_obligado_cumplimiento_id
     */
    @OneToOne
    @JoinColumn(name = "territorio_obligado_cumplimiento_id")
    private ObligadoCumplimiento obligadoCumplimiento;
}
