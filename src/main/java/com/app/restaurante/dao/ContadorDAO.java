package com.app.restaurante.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ContadorDAO {

    private final JdbcTemplate jdbcTemplate;

    public ContadorDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Devuelve un reporte de los productos más consumidos.
     * @param limite Cantidad de productos a incluir en el reporte.
     * @return Lista de mapas donde cada entrada representa un producto con su conteo.
     */
    public List<Map<String, Object>> obtenerProductosMasConsumidos(int limite) {
        String sql = "SELECT p.IDProducto, p.NomProducto, SUM(c.Cantidad) AS totalConsumido " +
                     "FROM carrito c " +
                     "JOIN producto p ON c.IDProducto = p.IDProducto " +
                     "GROUP BY p.IDProducto " +
                     "ORDER BY totalConsumido DESC " +
                     "LIMIT ?";
        return jdbcTemplate.queryForList(sql, limite);
    }
}
