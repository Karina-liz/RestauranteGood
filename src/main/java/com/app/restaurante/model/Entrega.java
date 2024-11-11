package com.app.restaurante.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "entrega")
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEntrega;

    private LocalDateTime horaSalida;
    private LocalDateTime horaEntrega;

    @ManyToOne
    @JoinColumn(name = "IDDelivery")
    private Delivery delivery;

    // Getters y Setters
}
