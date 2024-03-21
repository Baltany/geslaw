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
public class Alertas{

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;

     private Integer id_tipocomunabstractlaw;

     private Date fecha;

     private Integer id_usuario;

     private Integer id_sede;



}