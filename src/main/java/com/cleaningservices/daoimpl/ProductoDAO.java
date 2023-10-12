package com.cleaningservices.daoimpl;


import com.cleaningservices.abstracts.AbstractDAO;
import com.cleaningservices.entity.ProductoEntity;
import com.cleaningservices.utilities.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductoDAO extends AbstractDAO {

    Connector connector = new Connector();
    @Override
    public void insertar(Object entidad) {
        if (entidad instanceof ProductoEntity) {
            ProductoEntity producto = (ProductoEntity) entidad;
            String queryAddProducto = "INSERT INTO producto (NOMBRE, CATEGORIA_ID, MEDIDA, PRECIO) " +
                    "VALUES (?, ?, ?, ?)";

            try (PreparedStatement statement = connector.getConnection().prepareStatement(queryAddProducto)) {
                statement.setString(1, producto.getNombreProducto());
                statement.setInt(2, producto.getCategoriaProducto());
                statement.setString(3, producto.getMedidaProducto());
                statement.setDouble(4, producto.getPrecioProducto());
                statement.executeUpdate();
                System.out.println("Se ha insertado el producto: " + producto.getNombreProducto() + " " +
                        producto.getCategoriaProducto() + " " +
                        producto.getMedidaProducto() + " " +
                        producto.getPrecioProducto());
            } catch (SQLException e) {
                System.out.println("Error SQL: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Error General: " + e.getMessage());
                e.printStackTrace();
            }
        }else {
            System.out.println("No se puede insertar el objeto");
        }
    }

    @Override
    public void mostrarTabla() {
        String queryMostrarData = "SELECT * FROM producto limit 20";

        try (Statement statement = connector.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(queryMostrarData)) {
            System.out.println("ID :  DATOS DEL PRODUCTO");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ID_PRODUCTO") + " : " +
                        resultSet.getString("NOMBRE") + " " +
                        resultSet.getInt("CATEGORIA_ID") + " " +
                        resultSet.getString("MEDIDA") + " " +
                        resultSet.getDouble("PRECIO"));
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
