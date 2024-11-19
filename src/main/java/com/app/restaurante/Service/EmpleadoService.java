package com.app.restaurante.service;

import com.app.restaurante.model.Empleado;
import java.util.List;

public interface EmpleadoService {
    public List<Empleado> listarEmpleados();

    public Empleado guardarEmpleado(Empleado empleado);

    public Empleado obtenerEmpleadoPorId(Integer id);

    public Empleado actualizarEmpleado(Empleado empleado);
    
    public void eliminarEmpleado(Integer id);

}
