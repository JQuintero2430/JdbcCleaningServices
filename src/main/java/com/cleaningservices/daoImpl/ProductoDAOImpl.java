package com.cleaningservices.daoImpl;

import com.cleaningservices.dao.IInsertar;
import com.cleaningservices.dao.IMostrarTabla;
import com.cleaningservices.entity.ProductoEntity;
import com.cleaningservices.utilities.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductoDAOImpl implements IInsertar<ProductoEntity>, IMostrarTabla {
    Connector connector = new Connector();

    @Override
    public void insertar(ProductoEntity producto) {
        String queryAddProducto = "INSERT INTO producto (NOMBRE, CATEGORIA_ID, MEDIDA, PRECIO) " +
                "VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connector.getConnection().prepareStatement(queryAddProducto)) {
            statement.setString(1, producto.getNombreProducto());
            statement.setString(2, producto.getCategoriaProducto());
            statement.setString(3, producto.getMedidaProducto());
            statement.setDouble(4, producto.getPrecioProducto());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mostrarTabla() {
        String queryMostrarData = "SELECT * FROM usuario limit 20";

        try (Statement statement = connector.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(queryMostrarData)) {
            System.out.println("ID :  DATOS DEL PRODUCTO");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ID_PRODUCTO") + " : " +
                        resultSet.getString("NOMBRE") + " " +
                        resultSet.getString("CATEGORIA_ID") + " " +
                        resultSet.getString("MEDIDA") + " " +
                        resultSet.getDouble("PRECIO"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
