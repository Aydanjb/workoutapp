package com.example.workoutapp;

import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface DAO<T> {

    T get(int id) throws SQLException;
    ObservableList<T> getAll() throws SQLException;
    int save(T t) throws SQLException;
    int insert(T t) throws SQLException;
    int update(T t) throws SQLException;
    int delete(T t) throws SQLException;
}
