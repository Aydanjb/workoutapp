package com.example.workoutapp;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
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
    private MenuButton exerciseDropDown;
    @FXML
    private TableView<Exercise> exerciseTable;
    @FXML
    private TableColumn<Exercise, String> exerciseCol;
    @FXML
    private TableColumn<Exercise, Integer> weightCol;
    @FXML
    private TableColumn<Exercise, Integer> setsCol;
    @FXML
    private TableColumn<Exercise, Integer> repsCol;
    @FXML
    private TableColumn<Exercise, Date> dateCol;

    @FXML
    private void initialize() throws SQLException {
        showExercises();
    }

    public void showExercises() throws SQLException {
        ExerciseDAO exerciseDAO = new ExerciseDAOImpl();
        ObservableList<Exercise> exercises = exerciseDAO.getAll();

        exerciseCol.setCellValueFactory(new PropertyValueFactory<Exercise, String>("exercise"));
        weightCol.setCellValueFactory(new PropertyValueFactory<Exercise, Integer>("weight"));
        setsCol.setCellValueFactory(new PropertyValueFactory<Exercise, Integer>("sets"));
        repsCol.setCellValueFactory(new PropertyValueFactory<Exercise, Integer>("reps"));
        dateCol.setCellValueFactory(new PropertyValueFactory<Exercise, Date>("dateCompleted"));

        exerciseTable.setItems(exercises);
    }

    public void addBtnOnAction(ActionEvent e) throws IOException {

    }

    public void validateInput() {

    }
}
