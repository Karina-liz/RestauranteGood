package com.app.restaurante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categoriaproducto")
public class CategoriaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    private String nomCategoria;
    private String descripcion;

    // Getters y Setters
}
