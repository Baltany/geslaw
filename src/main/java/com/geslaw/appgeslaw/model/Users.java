package com.geslaw.appgeslaw.model;

import java.util.Date;

import jakarta.persistence.Column;
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
public class Users {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    
    @Column(length = 20)
    private String apellido1;
    
    @Column(length = 20)
    private String apellido2;
    
    private String dni;
    
    private String email;
    
    private String iniciales;
    
    private String nCuenta;
    
    
    @Column(length = 30)
    private String nombre;
    /*
     * Password del usuario
     */
    private String pass;

    /*
     * Password del email del usuario
     */
    private String passMail;

    private Integer idReponsableCompras;

    private Integer idResponsablesPermisos;


    private Date ultimoAcceso;

    private Boolean bloqueado;


    private Date fechaNacimiento;


    private String telefono;

    
    /*
     * Sería una lista ya que un usuario puede tener un 
     */
    private String domicilio;

    /*
     * Numero de la seguridad social
     */
    private String nss;


    private String cp;

    private Integer idNivelEstudios;

    private Integer idLocalidad;

    private Integer idLocalidadTrabajo;

    private Integer sede;

    private Integer idResponsableLaboral;

    private Integer idResponableDietas;

    







}