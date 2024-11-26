package com.app.restaurante.service;

import com.app.restaurante.model.DetalleEmpleado;
import java.util.List;

public interface DetEmpleadoService {
    List<DetalleEmpleado> listarDetEmpleado();
    DetalleEmpleado obtenerDetEmpleadoPorId(Integer id);
    DetalleEmpleado guardarDetEmpleado (DetalleEmpleado detEmpleado);
    DetalleEmpleado actualizarDetEmpleado(DetalleEmpleado detEmpleado);
    void eliminarDetEmpleado (Integer id);


}
