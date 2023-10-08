package com.cleaningservices.entity;


import com.cleaningservices.abstracts.AbstractEntity;
import com.cleaningservices.utilities.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MetodoPagoEntity extends AbstractEntity {
    private int idMetodoPago;
    private String nombreMetodoPago;
    private Connector connector = new Connector();

    public MetodoPagoEntity(String nombreMetodoPago) {
        this.nombreMetodoPago = nombreMetodoPago;
    }

    public MetodoPagoEntity(int idMetodoPago, String nombreMetodoPago) {
        this.idMetodoPago = idMetodoPago;
        this.nombreMetodoPago = nombreMetodoPago;
    }

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
            System.out.println("El objeto no es una instancia de MetodoPagoEntity");
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

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getNombreMetodoPago() {
        return nombreMetodoPago;
    }

    public void setNombreMetodoPago(String nombreMetodoPago) {
        this.nombreMetodoPago = nombreMetodoPago;
    }


}
