package com.geslaw.appgeslaw.model;

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