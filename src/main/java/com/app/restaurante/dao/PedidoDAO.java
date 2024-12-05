package com.app.restaurante.dao;

import com.app.restaurante.model.Pedido;
//import com.app.restaurante.model.PedidoReporte;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PedidoDAO {

    private final JdbcTemplate jdbcTemplate;

    public PedidoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    protected String getTableName() {
        return "pedido";
    }

    /*
     * RELACIONADO CON EL ADMINITRADOR EMPLEADO
     */
    /*
     * Metodo para obtener todos los pedidos
    */

    public List<Pedido> obtenerPedidosPagados() {
        String sql = "SELECT c.idcliente, c.nombre, c.apellido, "+
                        "d.iddireccion, d.direccion, " +
                        "p.idpedido, " +
                        "MAX(pg.idpago) AS idPagoUltimo, " +
                        "MAX(pg.totalpago) AS totalPagoUltimo, " +
                        "MAX(pg.FechaPago) AS fechaPagoUltimo, " +
                        "p.Estado " +
                        "FROM cliente c " +
                        "INNER JOIN direccion d ON c.idcliente = d.idcliente " +
                        "INNER JOIN pedido p ON c.idcliente = p.idcliente " +
                        "INNER JOIN pago pg ON p.idpedido = pg.idpedido " +
                        "WHERE p.Estado = 'Pagado' " +
                        "GROUP BY c.idcliente, c.nombre, c.apellido, " +
                        "d.iddireccion, d.direccion, p.idpedido, p.Estado;";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Pedido.class));
    }

    /*
     * RELACIONADO CON EL DELIVERY
     */

     /*
 * Como se realiza el proceso del delivery
 * 
 * Primero se registra el delivery con el pedido el estado "Iniciado"
 * ingresamos la hora en la que inicia el delivery
 * 
 * En la tabla hay un campo IDEmpleado
 * Se relaciona cuando el empleado con el rol de delivery 
 * 
 * Aqui si el admin es quien asigana un pedido a un empleado
 * o el empleado es quien agarra el pedido y lo marca como suyo cuando lo recoge
 * 
 * El estado del delivery cambia a "En camino" cuando el empleado tiene el pedido
 * 
 * Cuando se entrega el pedido el estado cambia "Entregado"
 * se hace con un click al boton de pedido entregado
 */



}
