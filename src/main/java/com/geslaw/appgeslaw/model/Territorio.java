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

@Data
@Entity
@NoArgsConstructor
public class Territorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * DT1,DT2....
     */
    private String nombre;

    @OneToOne
    private Sede sede;

    
    @OneToOne
    @JoinColumn(name = "territorio_id")
    private ObligadoCumplimiento obligadoCumplimiento;
}
