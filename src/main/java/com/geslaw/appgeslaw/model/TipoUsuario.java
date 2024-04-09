package com.geslaw.appgeslaw.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
 * Hay que mirar los id de que clase vienen y porque y entender la base de datos
 */
@Data
@Entity
@NoArgsConstructor
public class TipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * DIRECTOR,COORDINADOR(Admin)
     */
    private String nombre;

    public List<TipoUsuario> getUsuarios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsuarios'");
    }

    public List<TipoUsuario> getTipoUsuario() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTipoUsuario'");
    }
}
