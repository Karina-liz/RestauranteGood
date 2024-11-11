package com.app.restaurante.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCarrito;

    private Integer cantidad;
    private BigDecimal precioProducto;

    @ManyToOne
    @JoinColumn(name = "IDProducto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "IDPedido")
    private Pedido pedido;

    // Getters y Setters
}
