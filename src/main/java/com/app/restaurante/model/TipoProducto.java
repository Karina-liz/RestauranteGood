package com.app.restaurante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipoproducto")
public class TipoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipo;

    @Column(length = 50, nullable = true)
    private String nomTipo;

    @Column(length = 150, nullable = true)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "IDCategoria")
    private CategoriaProducto categoria;

    // Getters y Setters
}
