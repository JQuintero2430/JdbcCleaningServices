package com.cleaningservices.utilities;

public class DataBaseDetails {
    private static final String URL = "jdbc:mysql://localhost:3306/cleaning_database";
    private static final String USER = "root";
    private static final String PASSWORD = "my5q1P455w0rd";

    public String getUrl() {
        return URL;
    }
    public String getUser() {
        return USER;
    }
    public String getPassword() {
        return PASSWORD;
    }

}
