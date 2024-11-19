package com.app.restaurante.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.app.restaurante.model.Productos;


public class CarritoDAO {
    // Inyección de dependencia de JdbcTemplate para ejecutar consultas SQL
    private final JdbcTemplate jdbcTemplate;

    /**
     * Constructor que recibe el JdbcTemplate
     */
    public CarritoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Método para obtener productos por categoría
     * @param categoria Nombre de la categoría a buscar
     * @return Lista de productos de la categoría especificada
     */
    @SuppressWarnings("deprecation")
    public List<Productos> obtenerPorCategoria(String categoria) {
        // Consulta SQL para obtener productos por categoría
        String sql = "SELECT idProducto, NomProducto, PrecioUnitario, FotoProducto, Descripcion, Cantidad FROM producto WHERE idCategoria = (SELECT idCategoria FROM categoriaproducto WHERE NomCategoria = ?);";
        List<Productos> productos = jdbcTemplate.query(sql, new Object[]{categoria}, new BeanPropertyRowMapper<>(Productos.class));
    
        // Verifica el contenido de los productos antes de retornarlos
        for (Productos producto : productos) {
            System.out.println("Producto: " + producto.getNomProducto() + ", FotoProducto: " + producto.getFotoProducto() + 
            ", Precio" + producto.getPrecioUnitario() + ", Cantidad" + producto.getCantidad() + "./");
        }    

        return productos;
    }

    /**
     * Método para obtener un producto por su ID
     * @param idProducto ID del producto a buscar
     * @return Producto encontrado
     */
    @SuppressWarnings("deprecation")
    public Productos obtenerProductoPorId(int idProducto) {
        // Consulta SQL para obtener un producto específico por su ID
        String sql = "SELECT idProducto, NomProducto, PrecioUnitario, FotoProducto, Descripcion FROM producto WHERE idProducto = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{idProducto}, new BeanPropertyRowMapper<>(Productos.class));
    }
}
