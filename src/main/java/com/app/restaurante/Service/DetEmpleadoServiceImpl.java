package com.app.restaurante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.restaurante.model.DetalleEmpleado;
import com.app.restaurante.repository.DetalleEmpleadoRepository;
import java.util.List;

@Service
public class DetEmpleadoServiceImpl implements DetEmpleadoService{

    @Autowired
    private DetalleEmpleadoRepository detalleEmpleadoRepository;
    
    @Override
    public List<DetalleEmpleado> listarDetEmpleado() {
        return detalleEmpleadoRepository.findAll();
    }

    @Override
    public DetalleEmpleado obtenerDetEmpleadoPorId(Integer id) {
        return detalleEmpleadoRepository.findById(id).orElse(null);
    }

    @Override
    public DetalleEmpleado guardarDetEmpleado(DetalleEmpleado detEmpleado) {
        return detalleEmpleadoRepository.save(detEmpleado);
    }

    @Override
    public DetalleEmpleado actualizarDetEmpleado(DetalleEmpleado detEmpleado) {
        return detalleEmpleadoRepository.save(detEmpleado);
    }

    @Override
    public void eliminarDetEmpleado(Integer id) {
        detalleEmpleadoRepository.deleteById(id);
    }

}
