package com.cleaningservices.entity;

import com.cleaningservices.crudinterfaces.IActualizar;
import com.cleaningservices.crudinterfaces.IBorrar;
import com.cleaningservices.crudinterfaces.IInsertar;
import com.cleaningservices.crudinterfaces.IMostrarTabla;
import com.cleaningservices.utilities.Connector;

import java.sql.*;
import java.time.LocalDate;

public class UsuarioEntity implements IInsertar<UsuarioEntity>, IMostrarTabla, IActualizar, IBorrar {
    private int idUsuario;
    private String nombreUsuario;
    private String apellidoPaternoUsuario;
    private String apellidoMaternoUsuario;
    private String emailUsuario;
    private long telefonoUsuario;
    private LocalDate fechaNacimientoUsuario;
    private Connector connector = new Connector();

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

    @Override
    public void insertar(UsuarioEntity usuario) {
        String queryAddUsuario = "INSERT INTO usuario (NOMBRE, APELLIDO_PATERNO, APELLIDO_MATERNO, " +
                "EMAIL, NUMERO_TELEFONO, FECHA_NACIMIENTO) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connector.getConnection().prepareStatement(queryAddUsuario)) {
            statement.setString(1, usuario.getNombreUsuario());
            statement.setString(2, usuario.getApellidoPaternoUsuario());
            statement.setString(3, usuario.getApellidoMaternoUsuario());
            statement.setString(4, usuario.getEmailUsuario());
            statement.setLong(5, usuario.getTelefonoUsuario());
            statement.setDate(6, Date.valueOf(usuario.getFechaNacimientoUsuario()));
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error General: " + e.getMessage());
            e.printStackTrace();
        }
    }
    @Override
    public void mostrarTabla() {
        String queryMostrarData = "SELECT * FROM usuario limit 20";

        try (Statement statement = connector.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(queryMostrarData)) {
            System.out.println("ID :  DATOS DEL USUARIO");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ID_USUARIO") + " : " +
                        resultSet.getString("NOMBRE") + " " +
                        resultSet.getString("APELLIDO_PATERNO") + " " +
                        resultSet.getString("APELLIDO_MATERNO") + " " +
                        resultSet.getString("EMAIL") + " " +
                        resultSet.getLong("NUMERO_TELEFONO") + " " +
                        resultSet.getDate("FECHA_NACIMIENTO"));
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error General: " + e.getMessage());
            e.printStackTrace();
        }

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
