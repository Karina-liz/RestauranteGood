package com.app.restaurante.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
//Posible eliminar codigo muerto TODO ESTA EN CARRITO
@Repository
public class PedidoDAO {
    
    private final JdbcTemplate jdbcTemplate;

    public PedidoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    protected String getTableName() {
        return "pedido";
    }

    public void insertarPedido(Long idCliente, String fechaPedido) {
        String sql = "INSERT INTO " + getTableName() + " (IDCliente, FechaPedido, Estado) VALUES (?, ?,'Activo')";
        jdbcTemplate.update(sql, idCliente, fechaPedido);
    }

    

}
