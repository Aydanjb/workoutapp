package com.example.workoutapp;

import java.sql.Date;

public class Exercise {

    private long id;
    private String exercise;
    private int weight;
    private int sets;
    private int reps;
    private Date dateCompleted;

    public Exercise(long id, String exercise, int weight, int sets, int reps) {
        this.id = id;
        this.exercise = exercise;
        this.weight = weight;
        this.sets = sets;
        this.reps = reps;
        this.dateCompleted = new Date(System.currentTimeMillis());
    }
    public Exercise(long id, String exercise, int weight, int sets, int reps, Date dateCompleted) {
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

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", exercise='" + exercise + '\'' +
                ", weight=" + weight +
                ", sets=" + sets +
                ", reps=" + reps +
                ", dateCompleted=" + dateCompleted +
                '}';
    }
}
