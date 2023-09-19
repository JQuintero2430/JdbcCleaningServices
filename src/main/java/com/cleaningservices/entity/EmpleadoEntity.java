package com.cleaningservices.entity;

public class EmpleadoEntity {

    private int idEmpleado;
    private int idUsuario;
    private String posicionEmpleado;
    private String rolEmpleado;
    private String tipoDocumentoEmpleado;
    private long numeroDocumentoEmpleado;

    public EmpleadoEntity(int idUsuario, String posicionEmpleado, String rolEmpleado, String tipoDocumentoEmpleado, long numeroDocumentoEmpleado) {
        this.posicionEmpleado = posicionEmpleado;
        this.rolEmpleado = rolEmpleado;
        this.tipoDocumentoEmpleado = tipoDocumentoEmpleado;
        this.numeroDocumentoEmpleado = numeroDocumentoEmpleado;
    }

    public EmpleadoEntity(int idEmpleado, int idUsuario, String posicionEmpleado, String rolEmpleado, String tipoDocumentoEmpleado, long numeroDocumentoEmpleado) {
        this.idEmpleado = idEmpleado;
        this.posicionEmpleado = posicionEmpleado;
        this.rolEmpleado = rolEmpleado;
        this.tipoDocumentoEmpleado = tipoDocumentoEmpleado;
        this.numeroDocumentoEmpleado = numeroDocumentoEmpleado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getPosicionEmpleado() {
        return posicionEmpleado;
    }

    public void setPosicionEmpleado(String posicionEmpleado) {
        this.posicionEmpleado = posicionEmpleado;
    }

    public String getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(String rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public String getTipoDocumentoEmpleado() {
        return tipoDocumentoEmpleado;
    }

    public void setTipoDocumentoEmpleado(String tipoDocumentoEmpleado) {
        this.tipoDocumentoEmpleado = tipoDocumentoEmpleado;
    }

    public long getNumeroDocumentoEmpleado() {
        return numeroDocumentoEmpleado;
    }

    public void setNumeroDocumentoEmpleado(long numeroDocumentoEmpleado) {
        this.numeroDocumentoEmpleado = numeroDocumentoEmpleado;
    }
}
