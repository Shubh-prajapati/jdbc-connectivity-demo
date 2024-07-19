package com.example.jdbc_connectivity_demo.com_codenza.services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {
    public  Connection getConnection() {
        Connection connection = null;
        try {
            String url = " jdbc:mysql://localhost:3306/demodb";
            String username = "root";
            String password = " ";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to the database!");

        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return connection;
    }
}
