package com.cleaningservices.daoimpl;


import com.cleaningservices.abstracts.AbstractDAO;
import com.cleaningservices.entity.MetodoPagoEntity;
import com.cleaningservices.utilities.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MetodoPagoDAO extends AbstractDAO {

    Connector connector = new Connector();

    @Override
    public void insertar(Object entidad) {
        if (entidad instanceof MetodoPagoEntity){
            MetodoPagoEntity metodoPago = (MetodoPagoEntity) entidad;

            String queryAddMetodoPago = "INSERT INTO metodo_pago (NOMBRE_METODO_PAGO) " + "VALUES (?)";

            try (PreparedStatement statement = connector.getConnection().prepareStatement(queryAddMetodoPago)) {
                statement.setString(1, metodoPago.getNombreMetodoPago());
                statement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error SQL: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Error General: " + e.getMessage());
                e.printStackTrace();
            }
        }else {
            System.out.println("El objeto no es una instancia de MetodoPagoDAO");
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
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error General: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
