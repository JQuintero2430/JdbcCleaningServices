package com.cleaningservices.entity;

public class ProductoEntity {
    private int idProducto;
    private String nombreProducto;
    private String categoriaProducto;
    private String medidaProducto;
    private double precioProducto;

    public ProductoEntity(String nombreProducto, String categoriaProducto, String medidaProducto, double precioProducto) {
        this.nombreProducto = nombreProducto;
        this.categoriaProducto = categoriaProducto;
        this.medidaProducto = medidaProducto;
        this.precioProducto = precioProducto;
    }

    public ProductoEntity(int idProducto, String nombreProducto, String categoriaProducto, String medidaProducto, double precioProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.categoriaProducto = categoriaProducto;
        this.medidaProducto = medidaProducto;
        this.precioProducto = precioProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public String getMedidaProducto() {
        return medidaProducto;
    }

    public void setMedidaProducto(String medidaProducto) {
        this.medidaProducto = medidaProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }
}
