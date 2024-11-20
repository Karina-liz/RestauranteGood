/*
package com.app.restaurante.controller;

import com.app.restaurante.model.Empleado;
import com.app.restaurante.model.Rol;
import com.app.restaurante.service.EmpleadoService;
import com.app.restaurante.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private RolService rolService;

    @GetMapping
    public String getAllEmpleados(Model model) {
        List<Empleado> empleados = empleadoService.listarEmpleados();
        model.addAttribute("empleados", empleados);
        return "empleados";
    }

    @GetMapping("/nuevo")
    public String showCreateForm(Model model) {
        model.addAttribute("empleado", new Empleado());
        model.addAttribute("roles", rolService.listarRol());
        return "formEmpleados";
    }

    @PostMapping
    public String createEmpleado(@ModelAttribute Empleado empleado, @RequestParam Integer rolId) {
        empleadoService.guardarEmpleado(empleado, rolId);
        return "redirect:/empleados";
    }

    @GetMapping("/{id}/editar")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Empleado empleado = empleadoService.obtenerEmpleadoPorId(id);
        model.addAttribute("empleado", empleado);
        model.addAttribute("roles", rolService.listarRol());
        return "formEmpleados";
    }

    @PostMapping("/{id}")
    public String updateEmpleado(@PathVariable Integer id, @ModelAttribute Empleado empleado) {
        empleado.setIdEmpleado(id);
        //empleadoService.actualizarEmpleado(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/{id}/eliminar")
    public String deleteEmpleado(@PathVariable Integer id) {
        empleadoService.eliminarEmpleado(id);
        return "redirect:/empleados";
    }
}
   */