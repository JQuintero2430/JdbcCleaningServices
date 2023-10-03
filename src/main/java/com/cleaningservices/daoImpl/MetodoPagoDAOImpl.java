package com.cleaningservices.daoImpl;

import com.cleaningservices.dao.IActualizar;
import com.cleaningservices.dao.IBorrar;
import com.cleaningservices.dao.IInsertar;
import com.cleaningservices.dao.IMostrarTabla;
import com.cleaningservices.entity.MetodoPagoEntity;
import com.cleaningservices.utilities.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MetodoPagoDAOImpl implements IInsertar<MetodoPagoEntity>, IMostrarTabla, IActualizar, IBorrar {
    Connector connector = new Connector();

    @Override
    public void insertar(MetodoPagoEntity entidad) {
        String queryAddMetodoPago = "INSERT INTO metodo_pago (NOMBRE_METODO_PAGO) " + "VALUES (?)";

        try (PreparedStatement statement = connector.getConnection().prepareStatement(queryAddMetodoPago)) {
            statement.setString(1, entidad.getNombreMetodoPago());
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

    @Override
    public void actualizar(Integer id, String column, String value) {
        String queryActualizarMetodoPago = "UPDATE metodo_pago SET " + column + " = ? WHERE ID_METODO_PAGO = ?";

        try (PreparedStatement statement = connector.getConnection().prepareStatement(queryActualizarMetodoPago)) {
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
        String queryBorrarMetodoPago = "DELETE FROM metodo_pago WHERE ID_METODO_PAGO = ?";

        try (PreparedStatement statement = connector.getConnection().prepareStatement(queryBorrarMetodoPago)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error General: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
