package com.app.restaurante.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.app.restaurante.model.Cliente;
import com.app.restaurante.model.Direccion;
import com.app.restaurante.model.Productos;

@Repository
public class CuentaDAO {
    
    // Inyección de dependencia de JdbcTemplate para ejecutar consultas SQL
    private final JdbcTemplate jdbcTemplate;

    public CuentaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Método para obtener direcciones por ID de cliente
     */
    @SuppressWarnings("deprecation")
    public List<Direccion> obtenerDireccionesPorCliente(Long idCliente) {
        // Consulta SQL para obtener direcciones por ID de cliente
        String sql = "SELECT dir.idDireccion, dir.idCliente, dir.Direccion, dir.Referencia, di.distrito " +
                     "FROM direccion dir " +
                     "INNER JOIN Distrito di ON dir.IDDistrito = di.IDDistrito WHERE idCliente = ?;";
        List<Direccion> direcciones = jdbcTemplate.query(sql, new Object[]{idCliente}, new BeanPropertyRowMapper<>(Direccion.class));
    
        // Verifica el contenido de las direcciones antes de retornarlas
        //for (Direccion direccion : direcciones) {
        //    System.out.println("Direccion: " + direccion.getDireccion());
        //}    

        return direcciones;
    }

    /**
     * Método para obtener direcciones por ID de cliente
     */
    @SuppressWarnings("deprecation")
    public List<Direccion> obtenerPedidosPorCliente(Long idCliente) {
        // Consulta SQL para obtener direcciones por ID de cliente
        String sql = "SELECT ped.IDPedido, ped.Estado, pa.IDPago, pa.FechaPago, pa.TotalPago " +
                     "FROM pedido ped " +
                     "INNER JOIN pago pa ON ped.IDPedido = pa.IDPedido WHERE idCliente = ?;";
        List<Direccion> direcciones = jdbcTemplate.query(sql, new Object[]{idCliente}, new BeanPropertyRowMapper<>(Direccion.class));
    
        // Verifica el contenido de las direcciones antes de retornarlas
        //for (Direccion direccion : direcciones) {
        //    System.out.println("Direccion: " + direccion.getDireccion());
        //}    

        return direcciones;
    }

    // Metodo para obtener un cliente por ID
    @SuppressWarnings("deprecation")
    public Cliente findById(Long idCliente) {
        String sql = "SELECT * FROM cliente WHERE idCliente = ?";
        List<Cliente> clientes = jdbcTemplate.query(sql, new Object[] { idCliente }, new BeanPropertyRowMapper<>(Cliente.class));
        
        return clientes.isEmpty() ? null : clientes.get(0);
    }
}
