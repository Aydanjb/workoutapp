package com.example.workoutapp;

import java.sql.Date;

public class Entry {

    private long id;
    private String exercise;
    private int weight;
    private int sets;
    private int reps;
    private Date dateCompleted;

    public Entry(long id, String exercise, int weight, int sets, int reps) {
        this.id = id;
        this.exercise = exercise;
        this.weight = weight;
        this.sets = sets;
        this.reps = reps;
        this.dateCompleted = new Date(System.currentTimeMillis());
    }

    public Entry(long id, String exercise, int weight, int sets, int reps, Date dateCompleted) {
        this.id = id;
        this.exercise = exercise;
        this.weight = weight;
        this.sets = sets;
        this.reps = reps;
        this.dateCompleted = dateCompleted;
    }


    public String getExercise() {
        return exercise;
    }

    public int getReps() {
        return reps;
    }

    public int getSets() {
        return sets;
    }

    public int getWeight() {
        return weight;
    }

    public long getId() {
        return id;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", exercise='" + exercise + '\'' +
                ", weight=" + weight +
                ", sets=" + sets +
                ", reps=" + reps +
                ", dateCompleted=" + dateCompleted +
                '}';
    }
}
