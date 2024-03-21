
package com.geslaw.appgeslaw.model;

@Data
@Entity
@NoArgsConstructor

public class Articulos{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private float precio;

    private Integer subfamilia;
}