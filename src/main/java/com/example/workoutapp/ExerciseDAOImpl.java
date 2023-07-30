package com.example.workoutapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

// Implements CRUD methods for the Exercise class
public class ExerciseDAOImpl implements ExerciseDAO {

    @Override
    public Exercise get(int id) throws SQLException {
        DatabaseConnection connect = new DatabaseConnection();
        Connection connectDB = connect.getConnection();
        Exercise exercise = null;

        String query = "SELECT id, name FROM exercises WHERE id = ?";

        PreparedStatement preparedStatement = connectDB.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet queryResult = preparedStatement.executeQuery();

        if(queryResult.next()) {
            int oid = queryResult.getInt("id");
            String name = queryResult.getString("name");

            exercise = new Exercise(oid, name);
        }

        return exercise;
    }

    @Override
    public ObservableList<Exercise> getAll() throws SQLException {
        DatabaseConnection connect = new DatabaseConnection();
        Connection connectDB = connect.getConnection();

        String query = "SELECT id, name FROM exercises";

        ObservableList<Exercise> exercises = FXCollections.observableArrayList();

        Statement statement = connectDB.createStatement();
        ResultSet queryResult = statement.executeQuery(query);

        while(queryResult.next()) {
            int id = queryResult.getInt("id");
            String name = queryResult.getString("name");

            Exercise exercise = new Exercise(id, name);
            exercises.add(exercise);
        }
        return exercises;
    }

    @Override
    public int save(Exercise exercise) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Exercise exercise) throws SQLException {
        return 0;
    }

    @Override
    public int update(Exercise exercise) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Exercise exercise) throws SQLException {
        return 0;
    }
}
