package com.example.serverStudent.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.boot.jackson.autoconfigure.JacksonProperties;

@Entity
@Table(name = "tbl_tasks")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tasks")
    private Long idTasks;

    @Column(name = "number")
    @NotEmpty(message = "number do not empty")
    @JsonProperty("number")
    private int numberTasks;

    @Column(name = "name")
    @NotEmpty(message = "name do not empty")
    @JsonProperty("name")
    private String nameTasks;

    @Column(name = "description")
    @NotEmpty(message = "description do not empty")
    @JsonProperty("description")
    private String description;

    @Column(name = "countStars")
    @NotEmpty(message = "countStars do not empty")
    @JsonProperty("countStars")
    @Size
    private int countStars;

    @Column(name = "json")
    @NotEmpty(message = "json do not empty")
    @JsonProperty("json")
    private String json;

    public Tasks() {
    }

    public Tasks(int numberTasks, String nameTasks, String description, int countStars, String json) {
        this.numberTasks = numberTasks;
        this.nameTasks = nameTasks;
        this.description = description;
        this.countStars = countStars;
        this.json = json;
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
