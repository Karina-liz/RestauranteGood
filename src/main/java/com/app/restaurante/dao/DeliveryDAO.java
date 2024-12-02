package com.app.restaurante.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class DeliveryDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate; // Inyección de JdbcTemplate para ejecutar consultas SQL

    protected String getTableName() {
        return "delivery"; // Nombre de la tabla en la base de datos
    }
    
    // Consulta para crear el delivery de un pedido        
    public void registrarDelivery(Long idpedido) {        
        String sqlDelivery = "INSERT INTO delivery (Estado, FechaDelivery, IDPedido) VALUES (?, NOW(), ?)";
        jdbcTemplate.update(sqlDelivery, "Iniciado", idpedido);
    }

    
    
}

/*
 * Como se realiza el proceso del delivery
 * 
 * Primero se registra el delivery con el pedido el estado "Iniciado"
 * ingresamos la hora en la que inicia el delivery
 * 
 * En la tabla hay un campo IDEmpleado
 * Se relaciona cuando el empleado con el rol de delivery 
 * 
 * Aqui si el admin es quien asigana un pedido a un empleado
 * o el empleado es quien agarra el pedido y lo marca como suyo cuando lo recoge
 * 
 * El estado del delivery cambia a "En camino" cuando el empleado tiene el pedido
 * 
 * Cuando se entrega el pedido el estado cambia "Entregado"
 * se hace con un click al boton de pedido entregado
 */
