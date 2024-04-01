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

@Data
@Entity
@NoArgsConstructor
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;


    
    /*Una empresa tiene VARIAS sedes */
    @OneToMany
    @JoinColumn(name = "empresa_sedes_id")
    private List<Sede> sedes;
    

    @OneToMany
    @JoinColumn(name = "empresa_obligado_cumplimiento_id")
    /*
     * Ejemplo:Seguros....
     */
    private List<ObligadoCumplimiento> obligadoCumplimientos;
}
