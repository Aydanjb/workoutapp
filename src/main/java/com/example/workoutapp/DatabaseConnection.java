package com.example.workoutapp;
import java.sql.*;

// Connects to a postgresql database
public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "workoutapp";
        String databaseUser = "postgres";
        String databasePassword = "root";
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

    public static void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public static void closeStatement(Statement statement) throws SQLException {
        statement.close();
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.close();
    }

    public static void closeResultSet(ResultSet resultSet) throws SQLException {
        resultSet.close();
    }
}
