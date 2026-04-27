package com.example.infogames.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable()
public class Tasks {
    @DatabaseField()
    private String idTasks;

    @DatabaseField()
    private int numberTasks;

    @DatabaseField()
    private String nameTasks;

    @DatabaseField()
    private String description;

    @DatabaseField()
    private int countStars;

    @DatabaseField()
    private String json;

    public Tasks() {
    }

    public Tasks(String idTasks, int numberTasks, String nameTasks, String description, int countStars) {
        this.idTasks = idTasks;
        this.numberTasks = numberTasks;
        this.nameTasks = nameTasks;
        this.description = description;
        this.countStars = countStars;
    }

    public String getIdTasks() {
        return idTasks;
    }

    public void setIdTasks(String idTasks) {
        this.idTasks = idTasks;
    }

    public int getNumberTasks() {
        return numberTasks;
    }

    public void setNumberTasks(int numberTasks) {
        this.numberTasks = numberTasks;
    }

    public String getNameTasks() {
        return nameTasks;
    }

    public void setNameTasks(String nameTasks) {
        this.nameTasks = nameTasks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCountStars() {
        return countStars;
    }

    public void setCountStars(int countStars) {
        this.countStars = countStars;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
