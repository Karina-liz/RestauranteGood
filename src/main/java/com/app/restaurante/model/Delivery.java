package com.app.restaurante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDelivery;

    @Column(name = "Estado", length = 50)
    private String estado;

    @Column(name = "IDPedido")
    private Integer idPedido;

    @ManyToOne
    @JoinColumn(name = "IDEmpleado")
    private Empleado empleado;

    // Getters y Setters
}

