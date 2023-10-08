package com.cleaningservices.entity;

import com.cleaningservices.dao.IActualizar;
import com.cleaningservices.dao.IBorrar;
import com.cleaningservices.dao.IInsertar;
import com.cleaningservices.dao.IMostrarTabla;
import com.cleaningservices.utilities.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpleadoEntity implements IInsertar<EmpleadoEntity>, IMostrarTabla, IActualizar, IBorrar {

    private int idEmpleado;
    private String posicionEmpleado;
    private String rolEmpleado;
    private String tipoDocumentoEmpleado;
    private long numeroDocumentoEmpleado;
    private int idUsuario;
    private Connector connector = new Connector();

    public EmpleadoEntity(String posicionEmpleado, String rolEmpleado, String tipoDocumentoEmpleado, long numeroDocumentoEmpleado, int idUsuario1) {
        this.posicionEmpleado = posicionEmpleado;
        this.rolEmpleado = rolEmpleado;
        this.tipoDocumentoEmpleado = tipoDocumentoEmpleado;
        this.numeroDocumentoEmpleado = numeroDocumentoEmpleado;
        this.idUsuario = idUsuario1;
    }

    public EmpleadoEntity(int idEmpleado, String posicionEmpleado, String rolEmpleado, String tipoDocumentoEmpleado, long numeroDocumentoEmpleado, int idUsuario1) {
        this.idEmpleado = idEmpleado;
        this.posicionEmpleado = posicionEmpleado;
        this.rolEmpleado = rolEmpleado;
        this.tipoDocumentoEmpleado = tipoDocumentoEmpleado;
        this.numeroDocumentoEmpleado = numeroDocumentoEmpleado;
        this.idUsuario = idUsuario1;
    }

    @Override
    public void insertar(EmpleadoEntity entidad) {
        String queryAddEmpleado = "INSERT INTO empleado (POSICION, ROL, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, ID_USUARIO) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connector.getConnection().prepareStatement(queryAddEmpleado)) {
            statement.setString(1, entidad.getPosicionEmpleado());
            statement.setString(2, entidad.getRolEmpleado());
            statement.setString(3, entidad.getTipoDocumentoEmpleado());
            statement.setLong(4, entidad.getNumeroDocumentoEmpleado());
            statement.setInt(5, entidad.getIdUsuario());
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
        String queryMostrarData = "SELECT * FROM empleado limit 20";

        try (Statement statement = connector.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(queryMostrarData)) {
            System.out.println("ID :  DATOS DEL EMPLEADO");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ID_EMPLEADO") + " : " +
                        resultSet.getString("POSICION") + " " +
                        resultSet.getString("ROL") + " " +
                        resultSet.getString("TIPO_DOCUMENTO") + " " +
                        resultSet.getLong("NUMERO_DOCUMENTO") + " " +
                        resultSet.getInt("ID_USUARIO"));

            }
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error General: " + e.getMessage());
            e.printStackTrace();
        }
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
