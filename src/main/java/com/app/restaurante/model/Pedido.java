package com.app.restaurante.model;

import java.sql.Date;

public class Pedido {
    private Long idPedido;
    private Long idCliente;
    private Long idPago;
    private String EstadoPedido;
    private Date FechaPedido;
    private Date FechaPago;
    private Double TotalPago;
    private Double MontoFinal;
    
    // Getters y Setters
    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public String getEstadoPedido() {
        return EstadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.EstadoPedido = estadoPedido;
    }

    public Date getFechaPedido() {
        return FechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.FechaPedido = fechaPedido;
    }

    public Date getFechaPago() {
        return FechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.FechaPago = fechaPago;
    }

    public Double getTotalPago() {
        return TotalPago;
    }

    public void setTotalPago(Double totalPago) {
        this.TotalPago = totalPago;
    }

    public Double getMontoFinal() {
        return MontoFinal;
    }

    public void setMontoFinal(Double montoFinal) {
        this.MontoFinal = montoFinal;
    }
}
