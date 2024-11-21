package com.app.restaurante.controller;

import com.app.restaurante.model.DetalleEmpleado;
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

    @GetMapping("/nuevo")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("detalleEmpleado", new DetalleEmpleado());
        return "formDetalleEmpleado";
    }

    @PostMapping
    public String crearDetalle(@ModelAttribute DetalleEmpleado detalleEmpleado, @RequestParam Integer EmpleadoId) {
        Integer empleadoId = detalleEmpleado.getEmpleado().getIdEmpleado();
        detalleEmpleadoService.guardarDetalle(detalleEmpleado, empleadoId);
        return "redirect:/detalle-empleado";
    }

    @GetMapping("/{id}/editar")
    public String mostrarFormularioEdicion(@PathVariable Integer id, Model model) {
        DetalleEmpleado detalleEmpleado = detalleEmpleadoService.obtenerDetallePorId(id);
        model.addAttribute("detalleEmpleado", detalleEmpleado);
        return "formDetalleEmpleadoEditar";
    }
//FALTA ARREGLAR
    @PostMapping("/{id}")
    public String actualizarDetalle(@PathVariable Integer EmpleadoId, @ModelAttribute DetalleEmpleado detalleEmpleado) {
        Integer empleadoId = detalleEmpleado.getEmpleado().getIdEmpleado();
        detalleEmpleadoService.guardarDetalle(detalleEmpleado, empleadoId);
        return "redirect:/detalle-empleado";
    }

    @GetMapping("/{id}/eliminar")
    public String eliminarDetalle(@PathVariable Integer id) {
        detalleEmpleadoService.eliminarDetalle(id);
        return "redirect:/detalle-empleado";
    }
}