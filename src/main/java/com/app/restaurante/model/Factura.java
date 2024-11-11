package com.app.restaurante.model;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFactura;

    private BigDecimal costoTotal;
    private LocalDate fechaPedido;

    // Getters y Setters

}
