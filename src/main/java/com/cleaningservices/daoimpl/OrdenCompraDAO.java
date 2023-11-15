package com.cleaningservices.daoimpl;



import com.cleaningservices.abstracts.AbstractDAO;
import com.cleaningservices.models.OrdenCompraEntity;
import com.cleaningservices.utilities.Connector;

import java.sql.*;

public class OrdenCompraDAO extends AbstractDAO {

    Connector connector =  Connector.getInstance();

    @Override
    public void insertar(Object entidad) {
        if (entidad instanceof OrdenCompraEntity) {
            OrdenCompraEntity ordenCompra = (OrdenCompraEntity) entidad;
            String queryAddOrdenCompra = "INSERT INTO orden_compra (COMPRADOR_ID, VENDEDOR_ID, PRODUCTO_ID, CANTIDAD, " +
                    "FECHA_ORDEN, METODO_PAGO_ID, PRECIO) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement statement = connector.getConnection().prepareStatement(queryAddOrdenCompra)) {
                statement.setInt(1, ordenCompra.getCompradorIdOrdenCompra());
                statement.setInt(2, ordenCompra.getVendedorIdOrdenCompra());
                statement.setInt(3, ordenCompra.getProductoIdOrdenCompra());
                statement.setInt(4, ordenCompra.getCantidadOrdenCompra());
                statement.setDate(5, Date.valueOf(ordenCompra.getFechaOrdenCompra()));
                statement.setInt(6, ordenCompra.getMetodoPagoIdOrdenCompra());
                statement.setDouble(7, ordenCompra.getPrecioOrdenCompra());
                statement.executeUpdate();
                System.out.println("Se ha insertado la orden de compra: " + ordenCompra.getCompradorIdOrdenCompra() + " " +
                        ordenCompra.getVendedorIdOrdenCompra() + " " +
                        ordenCompra.getProductoIdOrdenCompra() + " " +
                        ordenCompra.getCantidadOrdenCompra() + " " +
                        ordenCompra.getFechaOrdenCompra() + " " +
                        ordenCompra.getMetodoPagoIdOrdenCompra() + " " +
                        ordenCompra.getPrecioOrdenCompra());
            } catch (SQLException e) {
                System.out.println("Error SQL: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Error General: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("No se puede insertar el objeto");
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
}
