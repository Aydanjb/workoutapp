package com.example.workoutapp;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class WorkoutsController {

    @FXML
    private Button addBtn;
    @FXML
    private TextField weightTextField;
    @FXML
    private TextField setsTextField;
    @FXML
    private TextField repsTextField;
    @FXML
    private ComboBox<String> exerciseDropDown;
    @FXML
    private TableView<Entry> exerciseTable;
    @FXML
    private TableColumn<Entry, String> exerciseCol;
    @FXML
    private TableColumn<Entry, Integer> weightCol;
    @FXML
    private TableColumn<Entry, Integer> setsCol;
    @FXML
    private TableColumn<Entry, Integer> repsCol;
    @FXML
    private TableColumn<Entry, Date> dateCol;

    // Displays entries and populates exercise drop-down when scene loads
    @FXML
    private void initialize() throws SQLException {
        showEntries();
        getExercises();
    }

    // Adds all existing entries in the database to the display table
    public void showEntries() throws SQLException {
        EntryDAO entryDAO = new EntryDAOImpl();
        ObservableList<Entry> entries = entryDAO.getAll();

        exerciseCol.setCellValueFactory(new PropertyValueFactory<Entry, String>("exercise"));
        weightCol.setCellValueFactory(new PropertyValueFactory<Entry, Integer>("weight"));
        setsCol.setCellValueFactory(new PropertyValueFactory<Entry, Integer>("sets"));
        repsCol.setCellValueFactory(new PropertyValueFactory<Entry, Integer>("reps"));
        dateCol.setCellValueFactory(new PropertyValueFactory<Entry, Date>("dateCompleted"));

        exerciseTable.setItems(entries);
    }

    // Populates the exercise drop-down menu with exercises in the database
    public void getExercises() throws SQLException {
        ExerciseDAO exerciseDAO = new ExerciseDAOImpl();
        ObservableList<Exercise> exercises = exerciseDAO.getAll();

        for (int i = 0; i < exercises.size() - 1; i++) {
            exerciseDropDown.getItems().add(exercises.get(i).getName());
        }
    }

    // When the add button is clicked inserts a new entry into the database and refreshes the display table
    public void addBtnOnAction(ActionEvent e) throws SQLException {
        if(!weightTextField.getText().isBlank() && !setsTextField.getText().isBlank() && !repsTextField.getText().isBlank()) {
            processInput();
        }
        else {
            System.out.println("blank text fields");
        }
    }

    // Inserts a new entry into the database and refreshes display table
    public void processInput() throws SQLException {
        DatabaseConnection connect = new DatabaseConnection();
        Connection connectDB = connect.getConnection();
        EntryDAO entryDAO = new EntryDAOImpl();

        long id = 0;
        String exercise = exerciseDropDown.getValue();
        int weight = Integer.parseInt(weightTextField.getText());
        int sets = Integer.parseInt(setsTextField.getText());
        int reps = Integer.parseInt(repsTextField.getText());

        Entry entry = new Entry(id, exercise, weight, sets, reps);

        entryDAO.insert(entry);

        showEntries();
    }
}
