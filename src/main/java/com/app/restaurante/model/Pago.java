package com.app.restaurante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPago;

    @ManyToOne
    @JoinColumn(name = "IDPedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "IDTipoPago")
    private TipoPago tipoPago;

    @ManyToOne
    @JoinColumn(name = "IDFactura")
    private Factura factura;

    private Integer estado;

    // Getters y Setters
}
