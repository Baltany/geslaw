package com.geslaw.appgeslaw.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;


/* @Data -> indicamos a spring que necesitamos getters y setters,por lo que los genera automáticamente
 * @Entity -> inidicamos a spring que es una clase entidad
 * @NoArgsConstructor -> no necesitamos los constructores,porque automáticamente los genera
 */
@Data
@Entity
@NoArgsConstructor
public class TipoSede {
    /*
     * Hace que cuando lanzamos spring y genere la base de datos automáticamente,detecte que este campo es un idy lo autoincremente
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;


}
