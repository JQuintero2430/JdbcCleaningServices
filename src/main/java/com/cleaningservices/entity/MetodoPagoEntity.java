package com.cleaningservices.entity;

public class MetodoPagoEntity {
    private int idMetodoPago;
    private String nombreMetodoPago;

    public MetodoPagoEntity(String nombreMetodoPago) {
        this.nombreMetodoPago = nombreMetodoPago;
    }

    public MetodoPagoEntity(int idMetodoPago, String nombreMetodoPago) {
        this.idMetodoPago = idMetodoPago;
        this.nombreMetodoPago = nombreMetodoPago;
    }

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getNombreMetodoPago() {
        return nombreMetodoPago;
    }

    public void setNombreMetodoPago(String nombreMetodoPago) {
        this.nombreMetodoPago = nombreMetodoPago;
    }


}
