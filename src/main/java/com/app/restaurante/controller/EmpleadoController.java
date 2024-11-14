/* package com.app.restaurante.controller;

import com.app.restaurante.model.Empleado;
import com.app.restaurante.model.Rol;
import com.app.restaurante.Service.EmpleadoService;
import com.app.restaurante.Service.RolService;
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
        List<Empleado> empleados = empleadoService.findAll();
        model.addAttribute("empleados", empleados);
        return "empleados/list";
    }

    @GetMapping("/nuevo")
    public String showCreateForm(Model model) {
        model.addAttribute("empleado", new Empleado());
        model.addAttribute("roles", rolService.findAll());
        return "empleados/form";
    }

    @PostMapping
    public String createEmpleado(@ModelAttribute Empleado empleado) {
        empleadoService.save(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/{id}/editar")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Empleado empleado = empleadoService.findById(id).orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado"));
        model.addAttribute("empleado", empleado);
        model.addAttribute("roles", rolService.findAll());
        return "empleados/form";
    }

    @PostMapping("/{id}")
    public String updateEmpleado(@PathVariable Integer id, @ModelAttribute Empleado empleado) {
        empleado.setIdEmpleado(id);
        empleadoService.save(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/{id}/eliminar")
    public String deleteEmpleado(@PathVariable Integer id) {
        empleadoService.deleteById(id);
        return "redirect:/empleados";
    }
}
*/