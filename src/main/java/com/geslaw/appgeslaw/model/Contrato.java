package com.geslaw.appgeslaw.model;

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
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Se podría poner las fechas como tipo Date
     */
    private String fechaInicio;

    private String fechaVencimiento;

    private String fechaModificacion;

    private String fichero;

    private String observaciones;

    private Boolean aplica;

    @OneToOne
    private Usuario usuario;

    /*
     * Un contrato solo puede pertenecer a una unica empresa,
     * pero una empresa tiene varios contratos
     */
    @ManyToOne
    private Empresa empresa;

    





}
