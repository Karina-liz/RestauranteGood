package com.app.restaurante.controller;

import com.app.restaurante.dao.ClienteDAO;
import com.app.restaurante.model.Cliente;
import com.app.restaurante.utils.Validation;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.NoSuchAlgorithmException;

@Controller
public class RegistroController {

    @Autowired
    private ClienteDAO clienteDAO;

    @Autowired
    private HttpSession session;

    // Endpoint para mostrar formulario de registro inicial
    @GetMapping("/registrarse")
    public String showRegistro(Model model) {
        return "registrarse";
    }

    // Endpoint principal para procesar el registro de nuevos clientes
    @PostMapping("/registrarse") 
    public String registrarCliente(@RequestParam("nombre") String nombre,
                                   @RequestParam("apellido") String apellido,
                                   @RequestParam("dni") String dni,
                                   @RequestParam("correo") String correo,
                                   @RequestParam("usuario") String usuario,
                                   @RequestParam("contrasena") String contrasena,
                                   @RequestParam("repetircontrasena") String repetirContrasena,                                                                   
                                   RedirectAttributes redirectAttributes) {

        // Validación de contraseñas
        if (!contrasena.equals(repetirContrasena)) {
            redirectAttributes.addFlashAttribute("error", "Las contraseñas no coinciden");
            return "redirect:/registrarse";
        }

        // Encriptación de contraseña por seguridad
        String hashedPassword;
        try {
            hashedPassword = Validation.md5(contrasena);
        } catch (NoSuchAlgorithmException e) {
            redirectAttributes.addFlashAttribute("error", "Error al encriptar la contraseña");
            return "redirect:/registrarse";
        }

        // Creación y población del objeto Cliente
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setNombre(nombre);
        nuevoCliente.setApellido(apellido);
        nuevoCliente.setDni(dni);
        nuevoCliente.setCorreo(correo);
        nuevoCliente.setUsuario(usuario);
        nuevoCliente.setContrasena(hashedPassword);

        // Persistencia del cliente en BD
        clienteDAO.save(nuevoCliente);

        // Inicio de sesión automático post-registro
        session.setAttribute("cliente", nuevoCliente);

        return "redirect:/registro_completar";
    }

    // Endpoint para página de bienvenida post-registro
    @GetMapping("/registro_completar")
    public String showBienvenido(Model model) {
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        if (cliente == null) {
            return "redirect:/login";
        }
        model.addAttribute("cliente", cliente);
        return "bienvenido";
    }
}
