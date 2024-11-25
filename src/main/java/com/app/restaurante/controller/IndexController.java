package com.app.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.restaurante.dao.ClienteDAO;
import com.app.restaurante.model.Cliente;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private ClienteDAO clienteDAO;

    @Autowired
    private HttpSession session;

    @GetMapping("/bienvenido")
    public String bienvenida(Model model) {
        // Verificar si el cliente está en sesión
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        if (cliente == null) {
            return "redirect:/login";
        }
        

        // Verificar si existe una dirección para el cliente
        Cliente direccion = clienteDAO.findDireccionByID(cliente.getIdCliente());
        model.addAttribute("mostrarModal", direccion == null); // Mostrar modal si no hay dirección
        model.addAttribute("cliente", cliente);

        return "bienvenido"; // Asegúrate de que hay una vista bienvenido.html
    }
    

    


}

