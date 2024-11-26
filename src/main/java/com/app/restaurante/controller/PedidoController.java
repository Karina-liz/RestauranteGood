package com.app.restaurante.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.restaurante.dao.PedidoDAO;

//Posible eliminar codigo muerto TODO ESTA EN CARRITO
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

    
}
