package com.cleaningservices.daoImpl;

import com.cleaningservices.dao.IInsertar;
import com.cleaningservices.dao.IMostrarTabla;
import com.cleaningservices.entity.EmpleadoEntity;
import com.cleaningservices.utilities.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmpleadoDAOImpl implements IInsertar<EmpleadoEntity>, IMostrarTabla {
    Connector connector = new Connector();

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
        } catch (Exception e) {
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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
