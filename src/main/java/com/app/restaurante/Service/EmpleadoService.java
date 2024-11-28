package com.app.restaurante.service;

import com.app.restaurante.model.DetalleEmpleado;
import com.app.restaurante.model.Empleado;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

public interface EmpleadoService {
    public List<Empleado> listarEmpleados();

    public Empleado guardarEmpleadoConDetalle(Empleado empleado, DetalleEmpleado detalle, Integer rolId);

    public Empleado guardarEmpleado(Empleado empleado, @RequestParam Integer rolId) throws IOException;

    public Empleado obtenerEmpleadoPorId(Integer id);

    public Empleado actualizarEmpleado(Empleado empleado, @RequestParam Integer rolId) throws IOException;
    
    public void eliminarEmpleado(Integer id);

}
