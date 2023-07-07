package com.example.workoutapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class ExerciseDAOImpl implements ExerciseDAO{

    @Override
    public Exercise get(int id) throws SQLException {
        DatabaseConnection connect = new DatabaseConnection();
        Connection connectDB = connect.getConnection();
        Exercise exercise = null;

        String query = "SELECT id, exercise, weight, sets, reps, date_completed FROM exercises WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connectDB.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet queryResult = preparedStatement.executeQuery();

            if(queryResult.next()) {
                int oid = queryResult.getInt("id");
                String exerciseName = queryResult.getString("exercise");
                int weight = queryResult.getInt("weight");
                int sets = queryResult.getInt("sets");
                int reps = queryResult.getInt("reps");
                Date dateCompleted = queryResult.getDate("date_completed");

                exercise = new Exercise(oid, exerciseName, weight, sets, reps, dateCompleted);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return exercise;
    }

    @Override
    public ObservableList<Exercise> getAll() throws SQLException {
        DatabaseConnection connect = new DatabaseConnection();
        Connection connectDB = connect.getConnection();

        String query = "SELECT id, exercise, weight, sets, reps, date_completed FROM exercises";

        ObservableList<Exercise> exercises = FXCollections.observableArrayList();

        Statement statement = connectDB.createStatement();
        ResultSet queryResult = statement.executeQuery(query);

        while(queryResult.next()) {
            int id = queryResult.getInt("id");
            String exerciseName = queryResult.getString("exercise");
            int weight = queryResult.getInt("weight");
            int sets = queryResult.getInt("sets");
            int reps = queryResult.getInt("reps");
            Date dateCompleted = queryResult.getDate("date_completed");

            Exercise exercise = new Exercise(id, exerciseName, weight, sets, reps, dateCompleted);
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
        DatabaseConnection connect = new DatabaseConnection();
        Connection connectDB = connect.getConnection();

        String query = "INSERT INTO exercises (exercise, weight, sets, reps) VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = connectDB.prepareStatement(query);
        preparedStatement.setString(1, exercise.getExercise());
        preparedStatement.setInt(2, exercise.getWeight());
        preparedStatement.setInt(3, exercise.getSets());
        preparedStatement.setInt(4, exercise.getReps());

        int result = preparedStatement.executeUpdate();

        DatabaseConnection.closePreparedStatement(preparedStatement);
        DatabaseConnection.closeConnection(connectDB);

        return result;
    }

    @Override
    public int update(Exercise exercise) throws SQLException {
        DatabaseConnection connect = new DatabaseConnection();
        Connection connectDB = connect.getConnection();

        String query = "UPDATE exercises SET exercise = ?, weight = ?, sets = ?, reps = ?, date_completed = ? WHERE id = ?";

        PreparedStatement preparedStatement = connectDB.prepareStatement(query);
        preparedStatement.setString(1, exercise.getExercise());
        preparedStatement.setInt(2, exercise.getWeight());
        preparedStatement.setInt(3, exercise.getSets());
        preparedStatement.setInt(4, exercise.getReps());
        preparedStatement.setDate(5, exercise.getDateCompleted());
        preparedStatement.setLong(6, exercise.getId());

        int result = preparedStatement.executeUpdate();

        DatabaseConnection.closePreparedStatement(preparedStatement);
        DatabaseConnection.closeConnection(connectDB);

        return result;
    }

    @Override
    public int delete(Exercise exercise) throws SQLException {
        DatabaseConnection connect = new DatabaseConnection();
        Connection connectDB = connect.getConnection();

        String query = "DELETE FROM exercises WHERE id = ?";

        PreparedStatement preparedStatement = connectDB.prepareStatement(query);
        preparedStatement.setLong(1, exercise.getId());

        int result = preparedStatement.executeUpdate();

        DatabaseConnection.closePreparedStatement(preparedStatement);
        DatabaseConnection.closeConnection(connectDB);

        return result;
    }
}
