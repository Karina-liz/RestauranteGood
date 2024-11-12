package com.app.restaurante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "direccion")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDireccion;

    @Column(length = 150, nullable = true)
    private String direccion;

    @Column(length = 150, nullable = true)
    private String referencia;

    @ManyToOne
    @JoinColumn(name = "IDDistrito")
    private Distrito distrito;

    @ManyToOne
    @JoinColumn(name = "IDCliente")
    private Cliente cliente;

    // Getters y Setters
}
