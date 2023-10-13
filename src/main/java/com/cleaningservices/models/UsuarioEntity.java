package com.cleaningservices.models;

import java.time.LocalDate;

public class UsuarioEntity{
    private int idUsuario;
    private String nombreUsuario;
    private String apellidoPaternoUsuario;
    private String apellidoMaternoUsuario;
    private String emailUsuario;
    private long telefonoUsuario;
    private LocalDate fechaNacimientoUsuario;

    public UsuarioEntity(String nombreUsuario, String apellidoPaternoUsuario, String apellidoMaternoUsuario, String emailUsuario, long telefonoUsuario, LocalDate fechaNacimientoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoPaternoUsuario = apellidoPaternoUsuario;
        this.apellidoMaternoUsuario = apellidoMaternoUsuario;
        this.emailUsuario = emailUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.fechaNacimientoUsuario = fechaNacimientoUsuario;
    }

    public UsuarioEntity(int idUsuario, String nombreUsuario, String apellidoPaternoUsuario, String apellidoMaternoUsuario, String emailUsuario, long telefonoUsuario, LocalDate fechaNacimientoUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoPaternoUsuario = apellidoPaternoUsuario;
        this.apellidoMaternoUsuario = apellidoMaternoUsuario;
        this.emailUsuario = emailUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.fechaNacimientoUsuario = fechaNacimientoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoPaternoUsuario() {
        return apellidoPaternoUsuario;
    }

    public void setApellidoPaternoUsuario(String apellidoPaternoUsuario) {
        this.apellidoPaternoUsuario = apellidoPaternoUsuario;
    }

    public String getApellidoMaternoUsuario() {
        return apellidoMaternoUsuario;
    }

    public void setApellidoMaternoUsuario(String apellidoMaternoUsuario) {
        this.apellidoMaternoUsuario = apellidoMaternoUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public long getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(long telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public LocalDate getFechaNacimientoUsuario() {
        return fechaNacimientoUsuario;
    }

    public void setFechaNacimientoUsuario(LocalDate fechaNacimientoUsuario) {
        this.fechaNacimientoUsuario = fechaNacimientoUsuario;
    }
}
