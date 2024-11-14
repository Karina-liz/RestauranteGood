package com.app.restaurante.Service;

import com.app.restaurante.model.Empleado;
import com.app.restaurante.dao.EmpleadoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl {

    @Autowired
    private EmpleadoDAO empleadoDAO;

    public List<Empleado> findAll() {
        return empleadoDAO.findAll();
    }

    public Optional<Empleado> findById(Integer id) {
        return empleadoDAO.findById(id);
    }

    public Empleado save(Empleado empleado) {
        return empleadoDAO.save(empleado);
    }

    public void deleteById(Integer id) {
        empleadoDAO.deleteById(id);
    }
}
