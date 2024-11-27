package com.app.restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.restaurante.dao.ClienteDAO;
import com.app.restaurante.dao.CuentaDAO;
import com.app.restaurante.model.Cliente;
import com.app.restaurante.model.Direccion;

import jakarta.servlet.http.HttpSession;

@Controller
public class CuentaController {
    
    @Autowired
    private ClienteDAO clienteDAO;

    @Autowired
    private CuentaDAO cuentaDAO;

    @Autowired
    private HttpSession session;   

    /**
     * Método que maneja la solicitud GET para mostrar la cuenta de un cliente
     */
    @GetMapping("/micuenta")
    public String mostrarCuenta(Model model) {                
        // Obtener el idCliente de la sesión
        Long idCliente = (Long) session.getAttribute("idCliente");
        if (idCliente == null) {
            return "redirect:/login";
        }


        // Buscar el cliente por su id
        Cliente cliente = cuentaDAO.findById(idCliente);
        if (cliente == null) {
            model.addAttribute("mensaje", "Cliente no encontrado.");
            return "micuenta";
        }
        // Agregar el cliente al modelo
        model.addAttribute("cliente", cliente);
        
        // Obtener las direcciones del cliente
        List<Direccion> direccion = cuentaDAO.obtenerDireccionesPorCliente(idCliente);
        model.addAttribute("direccion", direccion);

        // Obtener los pedidos del cliente
        //List<Pedido> pedido = cuentaDAO.obtenerPedidosPorCliente(idCliente);
        //model.addAttribute("pedido", pedido);

        return "micuenta";
    }

    
}
