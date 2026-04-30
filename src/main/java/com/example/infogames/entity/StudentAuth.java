package com.example.infogames.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentAuth {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String firstName;

    @JsonProperty("surname")
    private String lastName;

    @JsonProperty("role")
    private String role = "student";

    @JsonProperty("number")
    private int studentNumber;

    @JsonProperty("school")
    private String school;

    @JsonProperty("login")
    private String login;

    @JsonProperty("password")
    private String password;

    @JsonProperty("stars")
    private int countCoins = 0;

    public StudentAuth(){}

    public StudentAuth(String firstName, String lastName, String role, int classStudent, String school, String login, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.studentNumber = classStudent;
        this.school = school;
        this.login = login;
        this.password = password;
    }

    public StudentAuth(String role, int classStudent, String login, String password){
        this.role = role;
        this.studentNumber = classStudent;
        this.login = login;
        this.password = password;
    }

    public StudentAuth(String firstName, String lastName, int studentNumber, String school, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.school = school;
        this.login = login;
        this.password = password;
    }

    public void PrintInfo(){
        System.out.println(firstName + " " + lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
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

    public int getCountCoins() {
        return countCoins;
    }

    public void setCountCoins(int countCoins) {
        this.countCoins = countCoins;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
