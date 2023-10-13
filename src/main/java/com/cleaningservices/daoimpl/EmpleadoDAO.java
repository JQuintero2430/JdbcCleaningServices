package com.cleaningservices.daoimpl;

import com.cleaningservices.abstracts.AbstractDAO;
import com.cleaningservices.models.EmpleadoEntity;
import com.cleaningservices.utilities.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpleadoDAO extends AbstractDAO {

    Connector connector = new Connector();

    @Override
    public void insertar(Object entidad) {
        if ( entidad instanceof EmpleadoEntity) {
            EmpleadoEntity empleado = (EmpleadoEntity) entidad;

            String queryAddEmpleado = "INSERT INTO empleado (POSICION, ROL, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, ID_USUARIO) " +
                    "VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connector.getConnection().prepareStatement(queryAddEmpleado)) {
                statement.setString(1, empleado.getPosicionEmpleado());
                statement.setString(2, empleado.getRolEmpleado());
                statement.setString(3, empleado.getTipoDocumentoEmpleado());
                statement.setLong(4, empleado.getNumeroDocumentoEmpleado());
                statement.setInt(5, empleado.getIdUsuario());
                statement.executeUpdate();
                System.out.println("Se ha insertado el empleado: " + empleado.getPosicionEmpleado() + " " +
                        empleado.getRolEmpleado() + " " +
                        empleado.getTipoDocumentoEmpleado() + " " +
                        empleado.getNumeroDocumentoEmpleado() + " " +
                        empleado.getIdUsuario());
            } catch (SQLException e) {
                System.out.println("Error SQL: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Error General: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("El objeto no es una instancia de EmpleadoDAO");
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
}
