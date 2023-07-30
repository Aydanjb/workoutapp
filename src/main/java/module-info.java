module com.example.workoutapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    opens com.example.workoutapp to javafx.fxml;
    exports com.example.workoutapp;
}