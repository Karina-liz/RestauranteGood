package com.app.restaurante.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import com.app.restaurante.dao.PedidoDAO;
import com.app.restaurante.model.Pedido;

//Posible eliminar codigo muerto TODO ESTA EN CARRITO
// Ahora el PEDIDOCONTROLLER ES PARA EL EMPLEADO
@Controller

public class PedidoController {

    @GetMapping("/pedidos")
    public String mostrarReportes(Model model) {
        
        return "listPedidos";  // Nombre de la vista Thymeleaf
    }
}
