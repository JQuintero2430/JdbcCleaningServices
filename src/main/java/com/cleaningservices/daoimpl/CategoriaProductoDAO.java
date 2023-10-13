package com.cleaningservices.daoimpl;

import com.cleaningservices.abstracts.AbstractDAO;
import com.cleaningservices.models.CategoriaProductoEntity;
import com.cleaningservices.utilities.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoriaProductoDAO extends AbstractDAO {

    Connector connector = new Connector();

    @Override
    public void insertar(Object entidad) {
        if (entidad instanceof CategoriaProductoEntity) {
            CategoriaProductoEntity categoriaProducto = (CategoriaProductoEntity) entidad;

            String queryAddCategoriaProducto = "INSERT INTO categoria_producto (NOMBRE_CATEGORIA_PRODUCTO, TIPO_CATEGORIA_PRODUCTO) " +
                    "VALUES (?, ?)";

            try (PreparedStatement statement = connector.getConnection().prepareStatement(queryAddCategoriaProducto)) {
                statement.setString(1, categoriaProducto.getNombreCategoriaProducto());
                statement.setString(2, categoriaProducto.getTipoCategoriaProducto());
                statement.executeUpdate();
                System.out.println("Se ha insertado la categoria de producto: " + categoriaProducto.getNombreCategoriaProducto() + " " +
                        categoriaProducto.getTipoCategoriaProducto());
            } catch (SQLException e) {
                System.out.println("Error SQL: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Error General: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("El objeto no es una instancia de CategoriaProductoDAO");
        }

    }

    @Override
    public void mostrarTabla() {
        String queryMostrarDataCategoriaProducto = "SELECT * FROM categoria_producto limit 20";

        try (Statement statement = connector.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(queryMostrarDataCategoriaProducto)) {
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
