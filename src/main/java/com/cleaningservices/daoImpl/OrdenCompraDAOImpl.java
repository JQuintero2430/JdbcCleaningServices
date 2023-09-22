package com.cleaningservices.daoImpl;

import com.cleaningservices.dao.IInsertar;
import com.cleaningservices.dao.IMostrarTabla;
import com.cleaningservices.entity.OrdenCompraEntity;
import com.cleaningservices.utilities.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrdenCompraDAOImpl implements IInsertar<OrdenCompraEntity>, IMostrarTabla {
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
            statement.setDate(5, entidad.getFechaOrdenCompra());
            statement.setInt(6, entidad.getMetodoPagoIdOrdenCompra());
            statement.setDouble(7, entidad.getPrecioOrdenCompra());
        } catch (Exception e) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
