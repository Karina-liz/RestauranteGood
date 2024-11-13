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
    private ClienteDAO clienteDAO; // Inyectamos el ClienteDAO

    @Autowired
    private HttpSession session; // Inyección de la sesión HTTP

    // Método para mostrar el formulario de registro
    @GetMapping("/registrarse")
    public String showRegistro(Model model) {
        // Aquí puedes añadir otros atributos si es necesario
        return "registrarse";  // Retorna el formulario de registro
    }

    // Método para registrar un nuevo cliente
    @PostMapping("/registrarse")
    public String registrarCliente(@RequestParam("nombre") String nombre,
                                   @RequestParam("apellido") String apellido,
                                   @RequestParam("dni") String dni,
                                   @RequestParam("correo") String correo,
                                   @RequestParam("usuario") String usuario,
                                   @RequestParam("contrasena") String contrasena,
                                   @RequestParam("repetircontrasena") String repetirContrasena,
                                   @RequestParam("telefono") String telefono,
                                   //@RequestParam("fotoCliente") String fotoCliente,
                                   RedirectAttributes redirectAttributes) {

        // Validar que las contraseñas coinciden
        if (!contrasena.equals(repetirContrasena)) {
            redirectAttributes.addFlashAttribute("error", "Las contraseñas no coinciden");
            return "redirect:/registrarse";
        }

        // Encriptar la contraseña usando MD5
        String hashedPassword;
        try {
            hashedPassword = Validation.md5(contrasena); // Asegúrate de tener este método para encriptar
        } catch (NoSuchAlgorithmException e) {
            redirectAttributes.addFlashAttribute("error", "Error al encriptar la contraseña");
            return "redirect:/registrarse";
        }

        // Crear un nuevo cliente
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setNombre(nombre);
        nuevoCliente.setApellido(apellido);
        nuevoCliente.setDni(dni);
        nuevoCliente.setCorreo(correo);
        nuevoCliente.setUsuario(usuario);
        nuevoCliente.setContrasena(hashedPassword);  // Guardar la contraseña encriptada
        nuevoCliente.setTelefono(telefono);
        //nuevoCliente.setFotoCliente(fotoCliente);

        // Guardar el nuevo cliente en la base de datos
        clienteDAO.save(nuevoCliente);

        // Crear una sesión para el nuevo cliente
        session.setAttribute("cliente", nuevoCliente);

        // Redirigir a la página de registro exitoso o a otra página de tu elección
        return "redirect:/registro_completar";
    }

    // Método para mostrar la página de bienvenida
    @GetMapping("/registro_completar")
    public String showBienvenido(Model model) {
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        if (cliente == null) {
            return "redirect:/login"; // Si no hay cliente en sesión, redirige al login
        }
        model.addAttribute("cliente", cliente);  // Agregamos el cliente al modelo para mostrarlo
        return "bienvenido";  // Muestra la página de bienvenida
    }
}
