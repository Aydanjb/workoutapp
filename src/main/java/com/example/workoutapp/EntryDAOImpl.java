package com.example.workoutapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

// Implements CRUD methods for the Entry class
public class EntryDAOImpl implements EntryDAO {

    @Override
    public Entry get(int id) throws SQLException {
        DatabaseConnection connect = new DatabaseConnection();
        Connection connectDB = connect.getConnection();
        Entry entry = null;

        String query = "SELECT id, exercise, weight, sets, reps, date_completed FROM entries WHERE id = ?";

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

                entry = new Entry(oid, exerciseName, weight, sets, reps, dateCompleted);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return entry;
    }

    @Override
    public ObservableList<Entry> getAll() throws SQLException {
        DatabaseConnection connect = new DatabaseConnection();
        Connection connectDB = connect.getConnection();

        String query = "SELECT id, exercise, weight, sets, reps, date_completed FROM entries";

        ObservableList<Entry> entries = FXCollections.observableArrayList();

        Statement statement = connectDB.createStatement();
        ResultSet queryResult = statement.executeQuery(query);

        while(queryResult.next()) {
            int id = queryResult.getInt("id");
            String exerciseName = queryResult.getString("exercise");
            int weight = queryResult.getInt("weight");
            int sets = queryResult.getInt("sets");
            int reps = queryResult.getInt("reps");
            Date dateCompleted = queryResult.getDate("date_completed");

            Entry entry = new Entry(id, exerciseName, weight, sets, reps, dateCompleted);
            entries.add(entry);
        }
        return entries;
    }

    @Override
    public int save(Entry entry) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Entry entry) throws SQLException {
        DatabaseConnection connect = new DatabaseConnection();
        Connection connectDB = connect.getConnection();

        String query = "INSERT INTO entries (exercise, weight, sets, reps) VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = connectDB.prepareStatement(query);
        preparedStatement.setString(1, entry.getExercise());
        preparedStatement.setInt(2, entry.getWeight());
        preparedStatement.setInt(3, entry.getSets());
        preparedStatement.setInt(4, entry.getReps());

        int result = preparedStatement.executeUpdate();

        DatabaseConnection.closePreparedStatement(preparedStatement);
        DatabaseConnection.closeConnection(connectDB);

        return result;
    }

    @Override
    public int update(Entry entry) throws SQLException {
        DatabaseConnection connect = new DatabaseConnection();
        Connection connectDB = connect.getConnection();

        String query = "UPDATE entries SET exercise = ?, weight = ?, sets = ?, reps = ?, date_completed = ? WHERE id = ?";

        PreparedStatement preparedStatement = connectDB.prepareStatement(query);
        preparedStatement.setString(1, entry.getExercise());
        preparedStatement.setInt(2, entry.getWeight());
        preparedStatement.setInt(3, entry.getSets());
        preparedStatement.setInt(4, entry.getReps());
        preparedStatement.setDate(5, entry.getDateCompleted());
        preparedStatement.setLong(6, entry.getId());

        int result = preparedStatement.executeUpdate();

        DatabaseConnection.closePreparedStatement(preparedStatement);
        DatabaseConnection.closeConnection(connectDB);

        return result;
    }

    @Override
    public int delete(Entry entry) throws SQLException {
        DatabaseConnection connect = new DatabaseConnection();
        Connection connectDB = connect.getConnection();

        String query = "DELETE FROM entries WHERE id = ?";

        PreparedStatement preparedStatement = connectDB.prepareStatement(query);
        preparedStatement.setLong(1, entry.getId());

        int result = preparedStatement.executeUpdate();

        DatabaseConnection.closePreparedStatement(preparedStatement);
        DatabaseConnection.closeConnection(connectDB);

        return result;
    }
}
