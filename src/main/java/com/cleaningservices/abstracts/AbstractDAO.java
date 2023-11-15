package com.cleaningservices.abstracts;

import com.cleaningservices.daointerface.*;
import com.cleaningservices.utilities.Connector;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AbstractDAO implements IDAO {
    Connector connector = Connector.getInstance();
    @Override
    public void actualizar(Integer id, String tabla, String column, String value) {

        String queryActualizar = "UPDATE "+ tabla +" SET " + column + " = ? WHERE ID_USUARIO = ?";

        try (PreparedStatement statement = connector.getConnection().prepareStatement(queryActualizar)) {
            statement.setString(1, value);
            statement.setInt(2, id);
            statement.executeUpdate();
            System.out.println("Se ha actualizado el campo: " + column + " con el valor: " + value);
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error General: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id, String tabla) {
        String queryEliminarUsuario = "DELETE FROM "+ tabla + " WHERE ID_USUARIO = ?";

        try (PreparedStatement statement = connector.getConnection().prepareStatement(queryEliminarUsuario)) {
            statement.setInt(1, id);
            System.out.println("Se ha eliminado el usuario con el id: " + id);
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error General: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public abstract void insertar(Object entidad) ;

    @Override
    public abstract void mostrarTabla() ;

}
