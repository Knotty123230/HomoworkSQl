package org.example;

import java.sql.*;


import static org.example.constants.Constants.*;

public final class Database {
     private static Database instance;
     private Database(){

     }
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e1) {
            e1.fillInStackTrace();
        }
        return DriverManager.getConnection(JDBC_URL, user, pass);
    }
}
