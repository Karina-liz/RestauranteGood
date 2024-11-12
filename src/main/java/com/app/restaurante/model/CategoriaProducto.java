package com.app.restaurante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categoriaproducto")
public class CategoriaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    @Column(length = 50, nullable = true)
    private String nomCategoria;

    @Column(length = 150, nullable = true)
    private String descripcion;

    // Getters y Setters
}
