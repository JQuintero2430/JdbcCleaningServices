package com.cleaningservices.daoImpl;

import com.cleaningservices.dao.IActualizar;
import com.cleaningservices.dao.IBorrar;
import com.cleaningservices.dao.IInsertar;
import com.cleaningservices.dao.IMostrarTabla;
import com.cleaningservices.entity.CategoriaProductoEntity;
import com.cleaningservices.utilities.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoriaProductoDAOImpl implements IInsertar<CategoriaProductoEntity>, IMostrarTabla, IActualizar, IBorrar {
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

    @Override
    public void actualizar(Integer id, String column, String value) {
        String queryActualizarCategoriaProducto = "UPDATE categoria_producto SET " + column + " = ? WHERE ID_CATEGORIA_PRODUCTO = ?";
        try (PreparedStatement statement = connector.getConnection().prepareStatement(queryActualizarCategoriaProducto)) {
            statement.setString(2, value);
            statement.setInt(3, id);
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
        String queryBorrarCategoriaProducto = "DELETE FROM categoria_producto WHERE ID_CATEGORIA_PRODUCTO = ?";

        try (PreparedStatement statement = connector.getConnection().prepareStatement(queryBorrarCategoriaProducto)) {
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
