package com.geslaw.appgeslaw.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


/*Lo campos decimal los he puesto a double */

@Data
@Entity
@NoArgsConstructor
public class Cabecera_lista{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date fecha;

    private Integer id_sede;

    private Integer id_usuario;

    private String observaciones;

    private Boolean borrador;

    private Integer id_tipo;
    
    private Integer anterior;

    private double resultado;

    private double resultadoObligado;

    private double resultadoContratos;

    private double resultadoSubcontratas;

    private double resultadoSeguros;

    private double resultadoInspecciones;

    private double resultadoRegistros;


}