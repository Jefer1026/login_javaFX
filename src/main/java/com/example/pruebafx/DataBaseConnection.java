package com.example.pruebafx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static String dataBaseName = "login";
    private static String username = "root";
    private static String password = "sasa";
    private static String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
    private static Connection cn;

    public static Connection getInstance() throws SQLException {

        if (cn == null) {
            cn = DriverManager.getConnection(url, username, password);
        }
        return cn;

    }

}
