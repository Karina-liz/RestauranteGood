package com.app.restaurante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipopago")
public class TipoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoPago;

    @Column(length = 100, nullable = true)
    private String tipoPago;

    // Getters y Setters
}
