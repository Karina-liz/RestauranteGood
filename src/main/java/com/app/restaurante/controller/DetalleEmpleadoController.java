package com.app.restaurante.controller;

import com.app.restaurante.model.DetalleEmpleado;
import com.app.restaurante.model.Empleado;
import com.app.restaurante.model.EmpleadoDetalleDTO;
import com.app.restaurante.service.DetalleEmpleadoService;
import com.app.restaurante.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/detalle-empleado")
public class DetalleEmpleadoController {

    @Autowired
    private DetalleEmpleadoService detalleEmpleadoService;

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public String listarDetalles(Model model) {
        List<DetalleEmpleado> detalles = detalleEmpleadoService.listarDetalles();
        model.addAttribute("detalles", detalles);
        return "listDetalleEmpleado";
    }

    @PostMapping
    public String guardarEmpleadoDetalle(@ModelAttribute EmpleadoDetalleDTO empleadoDetalleDTO) {
        Empleado empleado = empleadoDetalleDTO.getEmpleado();
        empleadoService.guardarEmpleado(empleado, empleado.getRol().getIdRol());

        DetalleEmpleado detalleEmpleado = empleadoDetalleDTO.getDetalleEmpleado();
        detalleEmpleado.setEmpleado(empleado);
        detalleEmpleadoService.guardarDetalle(detalleEmpleado, empleado.getIdEmpleado());

        return "redirect:/empleados";
    }

    @GetMapping("/{id}/editar")
    public String mostrarFormularioEdicion(@PathVariable Integer id, Model model) {
        DetalleEmpleado detalleEmpleado = detalleEmpleadoService.obtenerDetallePorId(id);
        model.addAttribute("detalleEmpleado", detalleEmpleado);
        return "formDetalleEmpleadoEditar";
    }

    @PostMapping("/{id}")
    public String actualizarDetalle(@PathVariable Integer id, @ModelAttribute DetalleEmpleado detalleEmpleado) {
        detalleEmpleadoService.guardarDetalle(detalleEmpleado, id);
        return "redirect:/detalle-empleado";
    }

    @GetMapping("/{id}/eliminar")
    public String eliminarDetalle(@PathVariable Integer id) {
        detalleEmpleadoService.eliminarDetalle(id);
        return "redirect:/detalle-empleado";
    }
}
