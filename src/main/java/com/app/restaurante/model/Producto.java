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

    private String nomProducto;
    private BigDecimal precioUnitario;
    private String fotoProducto;
    private String descripcion;
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
