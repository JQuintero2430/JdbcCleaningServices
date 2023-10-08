package com.cleaningservices.crudinterfaces;

import com.cleaningservices.utilities.Connector;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface IActualizar {
    default void actualizar(Integer id, String tabla, String column, String value) {
        Connector connector = new Connector();
        String queryActualizar = "UPDATE "+ tabla +" SET " + column + " = ? WHERE ID_USUARIO = ?";

        try (PreparedStatement statement = connector.getConnection().prepareStatement(queryActualizar)) {
            statement.setString(1, value);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error General: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
