package com.app.restaurante.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.restaurante.model.Cliente;
import com.app.restaurante.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private HttpSession session;    
    
    @PostMapping("/login")
    public ModelAndView login(
            @RequestParam("email") String email, 
            @RequestParam("contrasena") String password,
            RedirectAttributes redirectAttributes)
             throws NoSuchAlgorithmException, IOException, CloneNotSupportedException {
        
        Cliente cliente = loginService.validateUser(email, password);  // Validación de credenciales
        
        if (cliente != null) {
            // Almacena el cliente en la sesión
            session.setAttribute("idCliente", cliente.getIdCliente()); // Almacena el ID del cliente
            session.setAttribute("usuario", cliente.getUsuario()); // Almacena el usuario del cliente
            session.setAttribute("nombre", cliente.getNombre()); // Almacena el nombre del cliente        
           
            // Redirige a la página de bienvenida o completar registro
            return new ModelAndView("redirect:/registro_completar");
        } else {
            // Si las credenciales son incorrectas, redirige al login con un mensaje de error
            redirectAttributes.addFlashAttribute("error", "Correo electrónico o contraseña inválidos");
            return new ModelAndView("redirect:/login");
        }
    }
    
    /* Nuevo método para manejar el cierre de sesión
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalida la sesión actual y destruye todos los datos
        return "redirect:/login"; // Redirige a la página de inicio de sesión
    }*/
    // Ver cual si  es efectivo
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // Aquí puedes agregar la lógica para invalidar la sesión
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalida la sesión
        }
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0
        response.setDateHeader("Expires", 0); // Proxies
        // Redirige al usuario a la página de inicio de sesión
        return "redirect:/login"; // Asegúrate de que esta ruta sea correcta
    }

}

