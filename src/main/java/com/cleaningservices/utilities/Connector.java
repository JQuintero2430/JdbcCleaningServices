package com.cleaningservices.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    DataBaseDetails dataBaseDetails = new DataBaseDetails();
    private Connection connection = null;

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(dataBaseDetails.getUrl(), dataBaseDetails.getUser(), dataBaseDetails.getPassword());
        }
        return connection;
    }
}
