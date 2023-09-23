package com.cleaningservices.daoImpl;

import com.cleaningservices.dao.IInsertar;
import com.cleaningservices.dao.IMostrarTabla;
import com.cleaningservices.entity.CategoriaProductoEntity;
import com.cleaningservices.utilities.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoriaProductoDAOImpl implements IInsertar<CategoriaProductoEntity>, IMostrarTabla {
    Connector connector = new Connector();

    @Override
    public void insertar(CategoriaProductoEntity entidad) {
        String queryAddCategoriaProducto = "INSERT INTO categoria_producto (NOMBRE_CATEGORIA_PRODUCTO, TIPO_CATEGORIA_PRODUCTO) " +
                "VALUES (?, ?)";

        try (PreparedStatement statement = connector.getConnection().prepareStatement(queryAddCategoriaProducto)) {
            statement.setString(1, entidad.getNombreCategoriaProducto());
            statement.setString(2, entidad.getTipoCategoriaProducto());
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
        String queryMostrarData = "SELECT * FROM categoria_producto limit 20";

        try (Statement statement = connector.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(queryMostrarData)) {
            System.out.println("ID :  DATOS DE LA CATEGORIA DE PRODUCTO");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ID_CATEGORIA_PRODUCTO") + " : " +
                        resultSet.getString("NOMBRE_CATEGORIA_PRODUCTO") + " " +
                        resultSet.getString("TIPO_CATEGORIA_PRODUCTO"));
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
