package com.geslaw.appgeslaw.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Usuario {
    

    /**
     * Private _id As Integer
Private _apellido1 As String
Private _apellido2 As String
Private _dni As String
Private _email As String
Private _iniciales As String
Private _ncuenta As String
Private _nombre As String
Private _pass As String
Private _passmail As String
Private _idResponsableCompras As Integer
Private _idResponsablePermisos As Integer
Private _ultimoAcceso As Date
Private _bloqueado As Boolean
Private _fechaNacimiento As Date
Private _nss As String
Private _telefono As String
Private _domicilio As String
Private _cp As String
Private _idLocalidad As Integer
Private _idNivelEstudios As Integer
Private _idLocalidadTrabajo As Integer
Private _sede As Integer
Private _idResponsableLaboral As Integer
Private _idResponsableDietas As Integer
Private _nombreCompleto As String
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String nombre;

    @Column(length = 20)
    private String apellido1;
    
    @Column(length = 20)
    private String apellido2;
    
    private String dni;

    private String email;

    private String iniciales;
    
    private String nCuenta;

    /*
     * Password del usuario
     */
    private String pass;

    /*
     * Password del email del usuario
     */
    private String passEmail;

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

    







}
