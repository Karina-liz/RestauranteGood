package com.app.restaurante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "direccion")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDireccion;

    private String direccion;
    private String referencia;

    @ManyToOne
    @JoinColumn(name = "IDDistrito")
    private Distrito distrito;

    @ManyToOne
    @JoinColumn(name = "IDCliente")
    private Cliente cliente;

    // Getters y Setters
}
