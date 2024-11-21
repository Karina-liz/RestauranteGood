package com.app.restaurante.service;

import com.app.restaurante.model.DetalleEmpleado;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

public interface DetalleEmpleadoService {
    List<DetalleEmpleado> listarDetalles();
    DetalleEmpleado guardarDetalle(DetalleEmpleado detalleEmpleado, @RequestParam Integer empleadoID);
    DetalleEmpleado obtenerDetallePorId(Integer id);
    void eliminarDetalle(Integer id);
}
