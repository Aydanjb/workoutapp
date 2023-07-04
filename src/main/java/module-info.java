module com.example.workoutapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;


    opens com.example.workoutapp to javafx.fxml;
    exports com.example.workoutapp;
}