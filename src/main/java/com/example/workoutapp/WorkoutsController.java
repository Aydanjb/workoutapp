package com.example.workoutapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;

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
    private TableColumn<Exercise, LocalDate> dateCol;

    public void addBtnOnAction(ActionEvent e) throws IOException {

    }

    public void validateInput() {

    }
}
