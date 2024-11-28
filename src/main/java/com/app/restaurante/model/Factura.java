package com.app.restaurante.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFactura;

    @Column(precision = 12, scale = 8, nullable = true)
    private BigDecimal costoTotal;

    private LocalDate fechaPedido;

    // Getters y Setters
}
