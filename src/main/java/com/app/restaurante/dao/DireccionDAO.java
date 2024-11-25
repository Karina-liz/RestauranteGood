package com.app.restaurante.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.app.restaurante.model.Direccion;

public class DireccionDAO {
    
    
    // Inyección de dependencia de JdbcTemplate para ejecutar consultas SQL
    private final JdbcTemplate jdbcTemplate;

    /**
     * Constructor que recibe el JdbcTemplate
     */
    public DireccionDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    /*
    -------------------------------------- 
    */
    // Método que devuelve el nombre de la tabla en la base de datos donde se almacenan las direcciones
    protected String getTableName() {
        return "direccion"; // Nombre de la tabla en la base de datos
    }

    // Método que devuelve el nombre de la tabla en la base de datos donde se almacenan los distritos
    protected String getDistritosTableName() {
        return "distritos"; // Nombre de la tabla en la base de datos
    }

    /*
     * Método para obtener todos los datos de la tabla dirección
     */
    public List<Direccion> findAllDirecciones() {
        // Consulta SQL para obtener todos los datos de la tabla dirección
        String sql = "SELECT iddireccion, idcliente, direccion, referencia, iddistrito FROM " + getTableName();
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Direccion.class));
    }

    /*
     * Método para obtener todos los datos de la tabla distritos
     */
    public List<Direccion> findAllDistritos() {
        // Consulta SQL para obtener todos los datos de la tabla distritos
        String sql = "SELECT idDistrito, distrito FROM " + getDistritosTableName();
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Direccion.class));
    }

}
