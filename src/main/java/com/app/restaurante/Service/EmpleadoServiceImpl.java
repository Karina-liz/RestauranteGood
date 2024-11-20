/*
package com.app.restaurante.service;

import com.app.restaurante.model.Empleado;
import com.app.restaurante.model.Rol;
import com.app.restaurante.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private RolService rolService;

    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado, Integer rolId) {
        Rol rol = rolService.obtenerRolPorId(rolId);
        empleado.setRol(rol);
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado obtenerEmpleadoPorId(Integer id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public Empleado actualizarEmpleado(Empleado empleado, Integer rolId) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Integer id) {
        empleadoRepository.deleteById(id);
    }
}
*/