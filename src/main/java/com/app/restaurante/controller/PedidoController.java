package com.app.restaurante.controller;

import com.app.restaurante.dao.PedidoDAO;
import com.app.restaurante.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PedidoController {

    private final PedidoDAO pedidoDAO;

    public PedidoController(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    @GetMapping("/listapedidos")
    public String mostrarReportes(Model model) {
        List<Pedido> pedidos = pedidoDAO.obtenerPedidosPagados();
        model.addAttribute("pedidos", pedidos);
        return "listPedidos";  // nombre de la vista Thymeleaf
    }
}
