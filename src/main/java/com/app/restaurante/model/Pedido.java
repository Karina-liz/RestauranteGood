package com.app.restaurante.model;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    private BigDecimal montoFinal;
    private String estado;
    private LocalDateTime fechaPedido;

    @ManyToOne
    @JoinColumn(name = "IDCliente")
    private Cliente cliente;

    // Getters y Setters
}
