package com.app.restaurante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.restaurante.model.DetalleEmpleado;
import com.app.restaurante.repository.DetalleEmpleadoRepository;

import java.io.IOException;
import java.util.List;

@Service
public class DetEmpleadoServiceImpl implements DetEmpleadoService{

    @Autowired
    private DetalleEmpleadoRepository detalleEmpleadoRepository;
    
    @Autowired
    private UploadServicio uploadServicio;


    @Override
    public List<DetalleEmpleado> listarDetEmpleado() {
        return detalleEmpleadoRepository.findAll();
    }

    @Override
    public DetalleEmpleado obtenerDetEmpleadoPorId(Integer id) {
        return detalleEmpleadoRepository.findById(id).orElse(null);
    }

    @Override
    public DetalleEmpleado guardarDetEmpleado(DetalleEmpleado detEmpleado, MultipartFile file) throws IOException {
        String nombreArchivo = uploadServicio.saveUpload(file);
        detEmpleado.setFoto(nombreArchivo);
        return detalleEmpleadoRepository.save(detEmpleado);
    }

    @Override
    public DetalleEmpleado actualizarDetEmpleado(DetalleEmpleado detEmpleado, MultipartFile file) throws IOException{
        if (!file.isEmpty()) {
            String nombreArchivo = uploadServicio.saveUpload(file);
            detEmpleado.setFoto(nombreArchivo);
        }
        return detalleEmpleadoRepository.save(detEmpleado);
    }

    @Override
    public void eliminarDetEmpleado(Integer id) {
        detalleEmpleadoRepository.deleteById(id);
    }

}
