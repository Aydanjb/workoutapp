package com.example.workoutapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "workoutapp";
        String databaseUser = "postgres";
        String databasePassword = "aydjb802";
        String url = "jdbc:postgresql://localhost:5432/" + databaseName;

        try {
            Class.forName("org.postgresql.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return databaseLink;
    }
}
