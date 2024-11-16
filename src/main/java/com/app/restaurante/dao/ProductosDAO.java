package com.app.restaurante.dao;

import com.app.restaurante.model.Productos;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductosDAO {

    private final JdbcTemplate jdbcTemplate;

    public ProductosDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Productos> obtenerPorCategoria(String categoria) {
        String sql = "SELECT idProducto, NomProducto, PrecioUnitario, FotoProducto, Descripcion, Cantidad FROM producto WHERE idCategoria = (SELECT idCategoria FROM categoriaproducto WHERE NomCategoria = ?);";
        List<Productos> productos = jdbcTemplate.query(sql, new Object[]{categoria}, new BeanPropertyRowMapper<>(Productos.class));

    
        // Verifica el contenido de los productos antes de retornarlos
        for (Productos producto : productos) {
            System.out.println("Producto: " + producto.getNomProducto() + ", FotoProducto: " + producto.getFotoProducto() + 
            ", Precio" + producto.getPrecioUnitario() + ", Cantidad" + producto.getCantidad() + "./");
        }
    
        return productos;
    }

    public Productos obtenerProductoPorId(int idProducto) {
        String sql = "SELECT idProducto, NomProducto, PrecioUnitario, FotoProducto, Descripcion FROM producto WHERE idProducto = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{idProducto}, new BeanPropertyRowMapper<>(Productos.class));
    }
    
    
    
}
