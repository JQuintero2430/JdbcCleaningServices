package com.cleaningservices.daoImpl;

import com.cleaningservices.dao.IActualizar;
import com.cleaningservices.dao.IBorrar;
import com.cleaningservices.dao.IInsertar;
import com.cleaningservices.dao.IMostrarTabla;
import com.cleaningservices.entity.OrdenCompraEntity;
import com.cleaningservices.utilities.Connector;

import java.sql.*;

public class OrdenCompraDAOImpl implements IInsertar<OrdenCompraEntity>, IMostrarTabla, IActualizar, IBorrar {
    Connector connector = new Connector();

    @Override
    public void insertar(OrdenCompraEntity entidad) {
        String queryAddOrdenCompra = "INSERT INTO orden_compra (COMPRADOR_ID, VENDEDOR_ID, PRODUCTO_ID, CANTIDAD, " +
                "FECHA_ORDEN, METODO_PAGO_ID, PRECIO) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connector.getConnection().prepareStatement(queryAddOrdenCompra)) {
            statement.setInt(1, entidad.getCompradorIdOrdenCompra());
            statement.setInt(2, entidad.getVendedorIdOrdenCompra());
            statement.setInt(3, entidad.getProductoIdOrdenCompra());
            statement.setInt(4, entidad.getCantidadOrdenCompra());
            statement.setDate(5, Date.valueOf(entidad.getFechaOrdenCompra()));
            statement.setInt(6, entidad.getMetodoPagoIdOrdenCompra());
            statement.setDouble(7, entidad.getPrecioOrdenCompra());
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
        String queryMostrarData = "SELECT * FROM orden_compra limit 20";

        try (Statement statement = connector.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(queryMostrarData)) {
            System.out.println("ID :  DATOS DE LA ORDEN DE COMPRA");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ID_ORDEN") + " : " +
                        resultSet.getInt("COMPRADOR_ID") + " " +
                        resultSet.getInt("VENDEDOR_ID") + " " +
                        resultSet.getInt("PRODUCTO_ID") + " " +
                        resultSet.getInt("CANTIDAD") + " " +
                        resultSet.getDate("FECHA_ORDEN") + " " +
                        resultSet.getInt("METODO_PAGO_ID") + " " +
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
        String queryActualizarOrdenCompra = "UPDATE orden_compra SET " + column + " = ? WHERE ID_ORDEN = ?";

        try (PreparedStatement statement = connector.getConnection().prepareStatement(queryActualizarOrdenCompra)) {
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

    @Override
    public void borrar(int id) {
        String queryBorrarOrdenCompra = "DELETE FROM orden_compra WHERE ID_ORDEN = ?";

        try (PreparedStatement statement = connector.getConnection().prepareStatement(queryBorrarOrdenCompra)) {
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
