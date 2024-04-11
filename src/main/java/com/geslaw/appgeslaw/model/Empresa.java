package com.geslaw.appgeslaw.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

/* @Data -> indicamos a spring que necesitamos getters y setters,por lo que los genera automáticamente
 * @Entity -> inidicamos a spring que es una clase entidad
 * @NoArgsConstructor -> no necesitamos los constructores,porque automáticamente los genera
 */
@Data
@Entity
@NoArgsConstructor
public class Empresa {

    /*
     * Hace que cuando lanzamos spring y genere la base de datos automáticamente,detecte que este campo es un idy lo autoincremente
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;


    
    /* @OneToMany -> Una empresa tiene VARIAS sedes
     * @JoinColumn -> le pasa el id de una tabla a otra
     */
    @OneToMany
    @JoinColumn(name = "empresa_sedes_id")
    private List<Sede> sedes;
    

    /* @OneToMany -> Una empresa tiene VARIOS obligados cumplimientos(seguros,contratos,autorizaciones....)
     * @JoinColumn -> le pasa el id de una tabla a otra
     */
    @OneToMany
    @JoinColumn(name = "empresa_obligado_cumplimiento_id")
    /*
     * Ejemplo:Seguros,Contratos,Autorizaciones....
     */
    private List<ObligadoCumplimiento> obligadoCumplimientos;
}
