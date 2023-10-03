package com.cleaningservices.daoImpl;

import com.cleaningservices.dao.IActualizar;
import com.cleaningservices.dao.IBorrar;
import com.cleaningservices.dao.IInsertar;
import com.cleaningservices.dao.IMostrarTabla;
import com.cleaningservices.entity.ProductoEntity;
import com.cleaningservices.utilities.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductoDAOImpl implements IInsertar<ProductoEntity>, IMostrarTabla, IActualizar, IBorrar {
    Connector connector = new Connector();

    @Override
    public void insertar(ProductoEntity producto) {
        String queryAddProducto = "INSERT INTO producto (NOMBRE, CATEGORIA_ID, MEDIDA, PRECIO) " +
                "VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connector.getConnection().prepareStatement(queryAddProducto)) {
            statement.setString(1, producto.getNombreProducto());
            statement.setInt(2, producto.getCategoriaProducto());
            statement.setString(3, producto.getMedidaProducto());
            statement.setDouble(4, producto.getPrecioProducto());
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

    @Override
    public void actualizar(Integer id, String column, String value) {
        String queryActualizarProducto = "UPDATE producto SET " + column + " = ? WHERE ID_PRODUCTO = ?";

        try (PreparedStatement statement = connector.getConnection().prepareStatement(queryActualizarProducto)) {
            statement.setString(1, value);
            statement.setInt(2, id);
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error General: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void borrar(int id) {
        String queryBorrarProducto = "DELETE FROM producto WHERE ID_PRODUCTO = ?";

        try (PreparedStatement statement = connector.getConnection().prepareStatement(queryBorrarProducto)) {
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
