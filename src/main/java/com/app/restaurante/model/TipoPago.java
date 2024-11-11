package com.app.restaurante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipopago")
public class TipoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoPago;

    private String tipoPago;

    // Getters y Setters
}
