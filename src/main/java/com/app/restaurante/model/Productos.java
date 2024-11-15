package com.app.restaurante.model;

public class Productos {

    private Long idProducto;
    private String NomProd;
    private double PrecioUnitario;
    private String descripcion;
    private int cantidad;
    private String FechaProducto;
    private String FotoProducto;

    private Long idCategoria;
    private Long idTipo;

    // Constructor vacío
    public Productos() {
    }

    // Constructor con todos los atributos (opcional)
    public Productos(Long idProducto, String NomProd, double PrecioUnitario, String descripcion, 
                     int cantidad, String FechaProducto, String FotoProducto, 
                     Long idCategoria, Long idTipo) {
        this.idProducto = idProducto;
        this.NomProd = NomProd;
        this.PrecioUnitario = PrecioUnitario;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.FechaProducto = FechaProducto;
        this.FotoProducto = FotoProducto;
        this.idCategoria = idCategoria;
        this.idTipo = idTipo;
    }

    // Getters y Setters
    public Long getIdProducto() {        return idProducto;    }
    public void setIdProducto(Long idProducto) {        this.idProducto = idProducto;    }

    public String getNomProd() {        return NomProd;    }
    public void setNomProd(String NomProd) {        this.NomProd = NomProd;    }

    public double getPrecioUnitario() {        return PrecioUnitario;    }
    public void setPrecioUnitario(double PrecioUnitario) {        this.PrecioUnitario = PrecioUnitario;    }

    public String getDescripcion() {        return descripcion;    }
    public void setDescripcion(String descripcion) {        this.descripcion = descripcion;    }

    public int getCantidad() {        return cantidad;    }
    public void setCantidad(int cantidad) {        this.cantidad = cantidad;    }

    public String getFechaProducto() {        return FechaProducto;    }
    public void setFechaProducto(String FechaProducto) {        this.FechaProducto = FechaProducto;    }

    public String getFotoProducto() {        return FotoProducto;    }
    public void setFotoProducto(String FotoProducto) {        this.FotoProducto = FotoProducto;    }

    public Long getIdCategoria() {        return idCategoria;    }
    public void setIdCategoria(Long idCategoria) {        this.idCategoria = idCategoria;    }

    public Long getIdTipo() {        return idTipo;    }
    public void setIdTipo(Long idTipo) {        this.idTipo = idTipo;    }

    

}
