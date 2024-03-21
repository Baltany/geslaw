package com.geslaw.appgeslaw.model;


/*
 * ESTAN TODOS LOS CAMPOS EN MAYUSCULA
 */
@Data
@Entity
@NoArgsConstructor
public class AltaLaboral{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String apellido1sustituidoalta;

    private String apellido2sustituidoalta;

    private String distribucionhoraria;

    private String dnisustituidoalta;

    private Date fechainicioalta;

    private String horassemanales;

    private Integer jornadanormal;

    private String minutossemanales;

    private String nombresustituidosalta;

    private String observacionesalta;

    private Integer titular;

    private Integer categoriaprofesionalalta_id;

}