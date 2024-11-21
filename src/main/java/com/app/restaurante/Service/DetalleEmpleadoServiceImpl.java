package com.app.restaurante.service;

import com.app.restaurante.model.DetalleEmpleado;
import com.app.restaurante.repository.DetalleEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleEmpleadoServiceImpl implements DetalleEmpleadoService {

    @Autowired
    private DetalleEmpleadoRepository detalleEmpleadoRepository;

    @Override
    public List<DetalleEmpleado> listarDetalles() {
        return detalleEmpleadoRepository.findAll();
    }

    @Override
    public DetalleEmpleado guardarDetalle(DetalleEmpleado detalleEmpleado) {
        return detalleEmpleadoRepository.save(detalleEmpleado);
    }

    @Override
    public DetalleEmpleado obtenerDetallePorId(Integer id) {
        return detalleEmpleadoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarDetalle(Integer id) {
        detalleEmpleadoRepository.deleteById(id);
    }
} 