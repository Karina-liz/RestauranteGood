package com.app.restaurante.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @Column(length = 100, nullable = true)
    private String nomProducto;

    @Column(precision = 12, scale = 8, nullable = true)
    private BigDecimal precioUnitario;

    @Column(length = 250, nullable = true)
    private String fotoProducto;

    @Column(length = 150, nullable = true)
    private String descripcion;

    @Column(nullable = true)
    private Integer cantidad;

    private LocalDateTime fechaProducto;

    @ManyToOne
    @JoinColumn(name = "IDCategoria")
    private CategoriaProducto categoria;

    @ManyToOne
    @JoinColumn(name = "IDTipo")
    private TipoProducto tipo;

    // Getters y Setters
}
