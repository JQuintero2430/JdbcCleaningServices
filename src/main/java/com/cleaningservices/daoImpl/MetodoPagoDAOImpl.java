package com.cleaningservices.daoImpl;

import com.cleaningservices.dao.IInsertar;
import com.cleaningservices.dao.IMostrarTabla;
import com.cleaningservices.entity.MetodoPagoEntity;
import com.cleaningservices.utilities.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MetodoPagoDAOImpl implements IInsertar<MetodoPagoEntity>, IMostrarTabla {
    Connector connector = new Connector();

    @Override
    public void insertar(MetodoPagoEntity entidad) {
        String queryAddMetodoPago = "INSERT INTO metodo_pago (NOMBRE_METODO_PAGO) " + "VALUES (?)";

        try (PreparedStatement statement = connector.getConnection().prepareStatement(queryAddMetodoPago)) {
            statement.setString(1, entidad.getNombreMetodoPago());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mostrarTabla() {
        String queryMostrarData = "SELECT * FROM metodo_pago limit 20";

        try (Statement statement = connector.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(queryMostrarData)) {
            System.out.println("ID :  DATOS DEL METODO DE PAGO");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ID_METODO_PAGO") + " : " +
                        resultSet.getString("NOMBRE_METODO_PAGO"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
