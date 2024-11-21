package com.app.restaurante.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository; 

import com.app.restaurante.model.Carrito;

@Repository  // Agregar esta anotación
public class CarritoDAO {
    // Inyección de dependencia de JdbcTemplate para ejecutar consultas SQL
    private final JdbcTemplate jdbcTemplate;

    /**
     * Constructor que recibe el JdbcTemplate
     */
    public CarritoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Método que devuelve el nombre de la tabla en la base de datos donde se almacenan los clientes
    protected String getTableName() {
        return "carrito"; // Nombre de la tabla en la base de datos
    }

    /*
     * Metodo para agregar un producto al carrito
     */
    public void guardarEnCarrito(Long idCliente, Long idProducto, int cantidad, double precioUnitario) {
        // Primero crear un nuevo pedido si no existe uno
        Integer idPedido = obtenerUltimoPedidoPorCliente(idCliente);
        if (idPedido == null) {
            String sqlPedido = "INSERT INTO pedido (IDCliente, FechaPedido, MontoFinal) VALUES (?, NOW(), 0)";
            jdbcTemplate.update(sqlPedido, idCliente);
            idPedido = obtenerUltimoPedidoPorCliente(idCliente);
        }

        // Insertar el producto en el carrito
        String sqlCarrito = "INSERT INTO carrito (IDPedido, IDProducto, Cantidad) VALUES (?, ?, ?)";
        jdbcTemplate.update(sqlCarrito, idPedido, idProducto, cantidad);

        // Actualizar el monto final del pedido
        String sqlActualizarMonto = "UPDATE pedido SET MontoFinal = MontoFinal + ? WHERE IDPedido = ?";
        jdbcTemplate.update(sqlActualizarMonto, cantidad * precioUnitario, idPedido);
    }

    

    /**
     * Método para obtener el último ID de pedido de un cliente
     */
    @SuppressWarnings("deprecation")
    public Integer obtenerUltimoPedidoPorCliente(Long idCliente) {
        String sql = "SELECT IDPedido FROM pedido WHERE IDCliente = ? ORDER BY FechaPedido DESC LIMIT 1";
        List<Integer> resultados = jdbcTemplate.queryForList(sql, new Object[]{idCliente}, Integer.class);
        return resultados.isEmpty() ? null : resultados.get(0);
    }

    /**
     * Método para obtener detalles completos del carrito por ID de pedido
     */
    @SuppressWarnings("deprecation")
    public List<Carrito> obtenerDetallesCarrito(int idPedido) {
        String sql = "SELECT p.NomProducto AS Producto, c.Cantidad AS Cantidad, " +
                    "p.PrecioUnitario AS PrecioUnitario, (c.Cantidad * p.PrecioUnitario) AS TotalProducto, " +
                    "c.IDCarrito, c.IDProducto, c.IDPedido, pe.MontoFinal AS TotalCarrito, " +
                    "cli.Nombre AS ClienteNombre, cli.Apellido AS ClienteApellido " +
                    "FROM carrito c " +
                    "JOIN producto p ON c.IDProducto = p.IDProducto " +
                    "JOIN pedido pe ON c.IDPedido = pe.IDPedido " +
                    "JOIN cliente cli ON pe.IDCliente = cli.IDCliente " +
                    "WHERE c.IDPedido = ?";

        return jdbcTemplate.query(sql, new Object[]{idPedido}, new BeanPropertyRowMapper<>(Carrito.class));
    }
}
