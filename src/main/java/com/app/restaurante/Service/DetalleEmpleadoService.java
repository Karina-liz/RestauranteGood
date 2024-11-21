package com.app.restaurante.service;

import com.app.restaurante.model.DetalleEmpleado;

import java.util.List;

public interface DetalleEmpleadoService {
    List<DetalleEmpleado> listarDetalles();
    DetalleEmpleado guardarDetalle(DetalleEmpleado detalleEmpleado);
    DetalleEmpleado obtenerDetallePorId(Integer id);
    void eliminarDetalle(Integer id);
}
