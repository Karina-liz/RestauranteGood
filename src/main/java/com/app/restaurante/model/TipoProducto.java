package com.app.restaurante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipoproducto")
public class TipoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipo;

    private String nomTipo;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "IDCategoria")
    private CategoriaProducto categoria;

    // Getters y Setters
}
