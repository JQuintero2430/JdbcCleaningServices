package com.cleaningservices.daoImpl;

import com.cleaningservices.dao.IDAO;
import com.cleaningservices.entity.UsuarioEntity;
import com.cleaningservices.utilities.Constant;

import java.sql.*;

public class UsuarioDAOImpl implements IDAO<UsuarioEntity> {

    private final String URL = Constant.URL;
    private final String USER = Constant.USER;
    private final String PASSWORD = Constant.PASSWORD;
    private Connection connection = null;

    private Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    @Override
    public void insertar(UsuarioEntity usuario) {
        String queryAddUsuario = "INSERT INTO usuario (NOMBRE, APELLIDO_PATERNO, APELLIDO_MATERNO, " +
                "EMAIL, NUMERO_TELEFONO, FECHA_NACIMIENTO) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = getConnection().prepareStatement(queryAddUsuario)) {
            statement.setString(1, usuario.getNombreUsuario());
            statement.setString(2, usuario.getApellidoPaternoUsuario());
            statement.setString(3, usuario.getApellidoMaternoUsuario());
            statement.setString(4, usuario.getEmailUsuario());
            statement.setLong(5, usuario.getTelefonoUsuario());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void mostrarData() {
        String queryMostrarData = "SELECT * FROM usuario limit 20";

        try (Statement statement = getConnection().createStatement();
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
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}