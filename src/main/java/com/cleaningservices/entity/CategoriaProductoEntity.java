package com.cleaningservices.entity;

public class CategoriaProductoEntity {
    private int idCategoriaProducto;
    private String nombreCategoriaProducto;
    private String tipoCategoriaProducto;

    public CategoriaProductoEntity(String nombreCategoriaProducto, String tipoCategoriaProducto) {
        this.nombreCategoriaProducto = nombreCategoriaProducto;
        this.tipoCategoriaProducto = tipoCategoriaProducto;
    }

    public CategoriaProductoEntity(int idCategoriaProducto, String nombreCategoriaProducto, String tipoCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
        this.nombreCategoriaProducto = nombreCategoriaProducto;
        this.tipoCategoriaProducto = tipoCategoriaProducto;
    }

    public int getIdCategoriaProducto() {
        return idCategoriaProducto;
    }

    public void setIdCategoriaProducto(int idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public String getNombreCategoriaProducto() {
        return nombreCategoriaProducto;
    }

    public void setNombreCategoriaProducto(String nombreCategoriaProducto) {
        this.nombreCategoriaProducto = nombreCategoriaProducto;
    }

    public String getTipoCategoriaProducto() {
        return tipoCategoriaProducto;
    }

    public void setTipoCategoriaProducto(String tipoCategoriaProducto) {
        this.tipoCategoriaProducto = tipoCategoriaProducto;
    }
}
