package com.app.restaurante.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import com.app.restaurante.dao.PedidoDAO;
import com.app.restaurante.model.Pedido;

import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con pedidos
 */
@Controller
public class PedidoController {
    
    private final PedidoDAO pedidoDAO;

    public PedidoController(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    @PostMapping("/registrar_pedido")
    public String registrarPedido(
        @RequestParam("idCliente") Long idCliente,
        @RequestParam("fechaPedido") String fechaPedido,
        RedirectAttributes redirectAttributes) {

        try {
            pedidoDAO.insertarPedido(idCliente, fechaPedido);
            redirectAttributes.addFlashAttribute("mensaje", "Pedido registrado exitosamente");
            return "redirect:/carta";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al registrar el pedido");
            return "redirect:/carta";
        }
    }

    /**
     * Muestra la lista de todos los pedidos
     * @param model Modelo para pasar datos a la vista
     * @return Vista de lista de pedidos
     */
    @GetMapping("/pedidos")
    public String mostrarTodosPedidos(Model model) {
        List<Pedido> pedidos = pedidoDAO.findAll();
        model.addAttribute("pedidos", pedidos);
        return "listPedidos";
    }
}
