package com.app.restaurante.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.restaurante.dao.ReporteDAO;
import com.app.restaurante.dao.ReporteProductosDAO;

@Controller
public class ReporteController {

    private final ReporteDAO reporteDao;

    @Autowired
    public ReporteController(ReporteDAO reporteDao) {
        this.reporteDao = reporteDao;
    }

    @Autowired
    private ReporteProductosDAO reporteProductosDAO;

    // Wa
    @GetMapping("/templates/reporte_productos")
    public String mostrarReporte(
            @RequestParam(required = false) String fechaInicio,
            @RequestParam(required = false) String fechaFin,
            Model model) {
            
        // Si no se proporcionan fechas, usa valores predeterminados
        if (fechaInicio == null || fechaFin == null) {
            LocalDate hoy = LocalDate.now();
            fechaInicio = hoy.toString(); // Fecha de hoy
            fechaFin = hoy.toString();
        }

        List<Map<String, Object>> reporte = reporteProductosDAO.obtenerReporte(fechaInicio, fechaFin);
        model.addAttribute("reporte", reporte);
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);
        return "reporte_productos";
    }
        
    // Wa
    @GetMapping("/templates/reporte_productos_sobra")
    public String mostrarReporteSobra(
            @RequestParam(required = false) String fechaInicio,
            @RequestParam(required = false) String fechaFin,
            Model model) {
            
        // Si no se proporcionan fechas, usa valores predeterminados
        if (fechaInicio == null || fechaFin == null) {
            LocalDate hoy = LocalDate.now();
            fechaInicio = hoy.toString(); // Fecha de hoy
            fechaFin = hoy.toString();
        }

        List<Map<String, Object>> reportesobra = reporteProductosDAO.obtenerReporteSobra(fechaInicio, fechaFin);
        model.addAttribute("reporte", reportesobra);
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);
        return "reporte_productos";
    }

    @GetMapping("/reportes-ingresos")
    public String mostrarReportes(Model model) {
        // Obtener los datos desde el DAO
        BigDecimal ingresosTotales = reporteDao.obtenerIngresosTotales();
        List<Map<String, Object>> ingresosProducto = reporteDao.obtenerIngresosPorProducto();
        List<Map<String, Object>> ingresosCliente = reporteDao.obtenerIngresosPorCliente();
        
        // Imprimir los datos para depurar
        System.out.println("Ingresos Totales: " + ingresosTotales);
        System.out.println("Ingresos por Producto: " + ingresosProducto);
        System.out.println("Ingresos por Cliente: " + ingresosCliente);
        
        // Convertir los ingresosProducto y ingresosCliente a listas de objetos más sencillos
        List<Map<String, Object>> ingresosProductoProcesados = ingresosProducto.stream()
            .map(item -> Map.of(
                "NomProducto", item.get("NomProducto"),
                "IngresosTotales", item.get("IngresosTotales")
            ))
            .collect(Collectors.toList());
        
        List<Map<String, Object>> ingresosClienteProcesados = ingresosCliente.stream()
            .map(item -> Map.of(
                "Nombre", item.get("Nombre"),
                "TotalGastado", item.get("TotalGastado")
            ))
            .collect(Collectors.toList());
        
        // Pasar los datos al modelo
        model.addAttribute("ingresosTotales", ingresosTotales);
        model.addAttribute("ingresosProducto", ingresosProductoProcesados);
        model.addAttribute("ingresosCliente", ingresosClienteProcesados);
        
        // Log para confirmar la acción
        System.out.println("Datos enviados al modelo para Thymeleaf: ");
        System.out.println("Ingresos Totales: " + ingresosTotales);
        System.out.println("Ingresos por Producto: " + ingresosProductoProcesados);
        System.out.println("Ingresos por Cliente: " + ingresosClienteProcesados);
        
        return "ingresos";  // Nombre de la vista Thymeleaf
    }


    
}
