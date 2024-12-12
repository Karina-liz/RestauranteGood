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

    // Reporte de cantidad vendida
    public List<Map<String, Object>> obtenerReporte(String fechaInicio, String fechaFin) {
        String sql = """
            SELECT idproducto, NomProducto, SUM(TotalCantidad) AS TotalCantidad, FechaReporte
            FROM reporte_productos
            WHERE FechaReporte BETWEEN ? AND ?
            GROUP BY idproducto, NomProducto, FechaReporte;
        """;
        return jdbcTemplate.queryForList(sql, fechaInicio, fechaFin);
    }

    // Reporte de cantidad sobrante
    public List<Map<String, Object>> obtenerReporteSobra(String fechaInicio, String fechaFin) {
        String sql = """
            SELECT rp.idproducto, rp.NomProducto, 
               (p.Cantidad - SUM(rp.TotalCantidad)) AS CantidadSobrante
            FROM reporte_productos rp
            INNER JOIN producto p ON rp.idproducto = p.IDProducto
            WHERE rp.FechaReporte BETWEEN ? AND ?
            GROUP BY rp.idproducto, rp.NomProducto, p.Cantidad;
        """;
        return jdbcTemplate.queryForList(sql, fechaInicio, fechaFin);
    }
    
}
