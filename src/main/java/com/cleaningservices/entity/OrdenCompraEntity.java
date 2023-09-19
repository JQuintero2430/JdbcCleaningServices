package com.cleaningservices.entity;

import java.util.Date;

public class OrdenCompraEntity {
    private int idOrdenCompra;
    private int compradorIdOrdenCompra;
    private int vendedorIdOrdenCompra;
    private int productoIdOrdenCompra;
    private int cantidadOrdenCompra;
    private Date fechaOrdenCompra;
    private int metodoPagoIdOrdenCompra;
    private double precioOrdenCompra;

    public OrdenCompraEntity(int compradorIdOrdenCompra, int vendedorIdOrdenCompra, int productoIdOrdenCompra, int cantidadOrdenCompra, Date fechaOrdenCompra, int metodoPagoIdOrdenCompra, double precioOrdenCompra) {
        this.compradorIdOrdenCompra = compradorIdOrdenCompra;
        this.vendedorIdOrdenCompra = vendedorIdOrdenCompra;
        this.productoIdOrdenCompra = productoIdOrdenCompra;
        this.cantidadOrdenCompra = cantidadOrdenCompra;
        this.fechaOrdenCompra = fechaOrdenCompra;
        this.metodoPagoIdOrdenCompra = metodoPagoIdOrdenCompra;
        this.precioOrdenCompra = precioOrdenCompra;
    }

    public OrdenCompraEntity(int idOrdenCompra, int compradorIdOrdenCompra, int vendedorIdOrdenCompra, int productoIdOrdenCompra, int cantidadOrdenCompra, Date fechaOrdenCompra, int metodoPagoIdOrdenCompra, double precioOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
        this.compradorIdOrdenCompra = compradorIdOrdenCompra;
        this.vendedorIdOrdenCompra = vendedorIdOrdenCompra;
        this.productoIdOrdenCompra = productoIdOrdenCompra;
        this.cantidadOrdenCompra = cantidadOrdenCompra;
        this.fechaOrdenCompra = fechaOrdenCompra;
        this.metodoPagoIdOrdenCompra = metodoPagoIdOrdenCompra;
        this.precioOrdenCompra = precioOrdenCompra;
    }

    public int getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(int idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public int getCompradorIdOrdenCompra() {
        return compradorIdOrdenCompra;
    }

    public void setCompradorIdOrdenCompra(int compradorIdOrdenCompra) {
        this.compradorIdOrdenCompra = compradorIdOrdenCompra;
    }

    public int getVendedorIdOrdenCompra() {
        return vendedorIdOrdenCompra;
    }

    public void setVendedorIdOrdenCompra(int vendedorIdOrdenCompra) {
        this.vendedorIdOrdenCompra = vendedorIdOrdenCompra;
    }

    public int getProductoIdOrdenCompra() {
        return productoIdOrdenCompra;
    }

    public void setProductoIdOrdenCompra(int productoIdOrdenCompra) {
        this.productoIdOrdenCompra = productoIdOrdenCompra;
    }

    public int getCantidadOrdenCompra() {
        return cantidadOrdenCompra;
    }

    public void setCantidadOrdenCompra(int cantidadOrdenCompra) {
        this.cantidadOrdenCompra = cantidadOrdenCompra;
    }

    public Date getFechaOrdenCompra() {
        return fechaOrdenCompra;
    }

    public void setFechaOrdenCompra(Date fechaOrdenCompra) {
        this.fechaOrdenCompra = fechaOrdenCompra;
    }

    public int getMetodoPagoIdOrdenCompra() {
        return metodoPagoIdOrdenCompra;
    }

    public void setMetodoPagoIdOrdenCompra(int metodoPagoIdOrdenCompra) {
        this.metodoPagoIdOrdenCompra = metodoPagoIdOrdenCompra;
    }

    public double getPrecioOrdenCompra() {
        return precioOrdenCompra;
    }

    public void setPrecioOrdenCompra(double precioOrdenCompra) {
        this.precioOrdenCompra = precioOrdenCompra;
    }
}
