package com.cleaningservices.daoimpl;

import com.cleaningservices.abstracts.AbstractDAO;
import com.cleaningservices.entity.UsuarioEntity;
import com.cleaningservices.utilities.Connector;

import java.sql.*;
import java.time.LocalDate;

public class UsuarioDAO extends AbstractDAO {

    Connector connector = new Connector();
    @Override
    public void insertar(Object entidad) {
        if (entidad instanceof UsuarioEntity) {
            UsuarioEntity usuario = (UsuarioEntity) entidad;

            String queryAddUsuario = "INSERT INTO usuario (NOMBRE, APELLIDO_PATERNO, APELLIDO_MATERNO, " +
                    "EMAIL, NUMERO_TELEFONO, FECHA_NACIMIENTO) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement statement = connector.getConnection().prepareStatement(queryAddUsuario)) {
                statement.setString(1, usuario.getNombreUsuario());
                statement.setString(2, usuario.getApellidoPaternoUsuario());
                statement.setString(3, usuario.getApellidoMaternoUsuario());
                statement.setString(4, usuario.getEmailUsuario());
                statement.setLong(5, usuario.getTelefonoUsuario());
                statement.setDate(6, Date.valueOf(usuario.getFechaNacimientoUsuario()));
                statement.executeUpdate();
                System.out.println("Se ha insertado el usuario: " + usuario.getNombreUsuario() + " " +
                        usuario.getApellidoPaternoUsuario() + " " +
                        usuario.getApellidoMaternoUsuario() + " " +
                        usuario.getEmailUsuario() + " " +
                        usuario.getTelefonoUsuario() + " " +
                        usuario.getFechaNacimientoUsuario()
                );
            } catch (SQLException e) {
                System.out.println("Error SQL: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Error General: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("El objeto no es una instancia de UsuarioDAO");
        }
    }
    @Override
    public void mostrarTabla() {
        String queryMostrarData = "SELECT * FROM usuario limit 20";

        try (Statement statement = connector.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(queryMostrarData)) {
            System.out.println("ID :  DATOS DEL USUARIO");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ID_USUARIO") + " : " +
                        resultSet.getString("NOMBRE") + " " +
                        resultSet.getString("APELLIDO_PATERNO") + " " +
                        resultSet.getString("APELLIDO_MATERNO") + " " +
                        resultSet.getString("EMAIL") + " " +
                        resultSet.getLong("NUMERO_TELEFONO") + " " +
                        resultSet.getDate("FECHA_NACIMIENTO"));
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
