package com.example.workoutapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class LoginController {

    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private Button loginBtn;

    public void loginBtnOnAction(ActionEvent e) throws IOException {
        if(!usernameTextField.getText().isBlank() && !passwordPasswordField.getText().isBlank()) {
            validateLogin();
        }
        else {
            loginMessageLabel.setText("Please enter a username and password");
        }
    }

    public void validateLogin() {
        DatabaseConnection connect = new DatabaseConnection();
        Connection connectDB = connect.getConnection();

        String verifyLogin = "SELECT count(1) FROM users WHERE username = '" + usernameTextField.getText() +
                "' AND password = '" + passwordPasswordField.getText() + "';";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()) {
                if(queryResult.getInt(1) == 1) {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("workouts.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage window = (Stage) loginBtn.getScene().getWindow();
                    window.setScene(scene);
                }
                else {
                    loginMessageLabel.setText("Invalid login.");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}