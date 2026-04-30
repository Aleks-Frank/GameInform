package com.example.serverStudent.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tbl_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id_student")
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "name do not empty")
    @JsonProperty("name")
    private String name;

    @Column(name = "surname")
    @NotEmpty(message = "surname do not empty")
    @JsonProperty("surname")
    private String surname;

    @Column(name = "role")
    @NotEmpty(message = "role do not empty")
    @JsonProperty("role")
    private String role;

    @Column(name = "class")
    @NotEmpty(message = "class do not empty")
    @Size(min = 1, max = 11)
    @JsonProperty("number")
    private int classStudent;

    @Column(name = "school")
    @JsonProperty("school")
    private String school;

    @Column(name = "login")
    @NotEmpty(message = "login do not empty")
    @JsonProperty("login")
    private String login;

    @Column(name = "password")
    @NotEmpty(message = "password do not empty")
    @JsonProperty("password")
    private String password;

    @Column(name = "stars")
    @NotEmpty(message = "stars do not empty")
    @Size
    @JsonProperty("stars")
    private int stars;

    public Student(String name, String surname, String role, int classStudent, String school, String login, String password, int stars) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.classStudent = classStudent;
        this.school = school;
        this.login = login;
        this.password = password;
        this.stars = stars;
    }

    public Student() {
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(int classStudent) {
        this.classStudent = classStudent;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

}
