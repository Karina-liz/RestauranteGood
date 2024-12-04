package com.app.restaurante.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.app.restaurante.model.Pedido;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 * Clase DAO para gestionar las operaciones de base de datos relacionadas con los pedidos
 */
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

    /**
     * Obtiene todos los pedidos de la base de datos
     * @return Lista de todos los pedidos
     */
    public List<Pedido> findAll() {
        String sql = "SELECT * FROM " + getTableName();
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Pedido.class));
    }

    /**
     * Busca un pedido específico por su ID
     * @param id ID del pedido a buscar
     * @return Pedido encontrado o null si no existe
     */
    public Pedido findById(Long id) {
        String sql = "SELECT * FROM " + getTableName() + " WHERE IDPedido = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Pedido.class), id);
    }
}
