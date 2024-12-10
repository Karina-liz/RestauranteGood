package com.app.restaurante.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReporteProductosDAO {
    private final JdbcTemplate jdbcTemplate;

    public ReporteProductosDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void actualizarReporteProducto(int idProducto, String nomProducto, int cantidad) {
        String sqlInsertar = """
            INSERT INTO reporte_productos (IDProducto, NomProducto, TotalCantidad, FechaReporte)
            VALUES (?, ?, ?, CURDATE())
            ON DUPLICATE KEY UPDATE
            TotalCantidad = TotalCantidad + VALUES(TotalCantidad);
        """;    
        jdbcTemplate.update(sqlInsertar, idProducto, nomProducto, cantidad);
    }

    public List<Map<String, Object>> obtenerReporte(String fechaInicio, String fechaFin) {
        String sql = """
            SELECT * FROM reporte_productos 
            WHERE FechaReporte BETWEEN ? AND ?
        """;
        return jdbcTemplate.queryForList(sql, fechaInicio, fechaFin);
    }
    
}
