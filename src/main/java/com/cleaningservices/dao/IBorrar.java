package com.cleaningservices.dao;

import com.cleaningservices.utilities.Connector;

import java.sql.PreparedStatement;
import java.sql.SQLException;
public interface IBorrar{
    default void borrar(int id, String tabla) {
        String queryBorrarUsuario = "DELETE FROM "+ tabla + " WHERE ID_USUARIO = ?";
        Connector connector = new Connector();

        try (PreparedStatement statement = connector.getConnection().prepareStatement(queryBorrarUsuario)) {
            statement.setInt(1, id);
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error General: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
