package com.app.restaurante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDelivery;

    @Column(length = 50, nullable = true)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "IDPedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "IDEmpleado")
    private Empleado empleado;

    // Getters y Setters
}

