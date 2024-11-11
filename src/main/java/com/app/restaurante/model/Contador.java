package com.app.restaurante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contador")
public class Contador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContador;

    private Integer contador;

    @ManyToOne
    @JoinColumn(name = "IDProducto")
    private Producto producto;

    // Getters y Setters
}
