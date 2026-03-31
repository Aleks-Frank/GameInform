package com.example.infogames.entity;

public class Student {
    private int id;

    private String firstName;

    private String lastName;

    private String role;

    private int classStudent;

    private String login;

    private String password;

    private int countCoins = 0;

    private int resultDragonPicker = 0;

    public Student(){}

    public Student(String firstName, String lastName, String role, int classStudent, String login, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.classStudent = classStudent;
        this.login = login;
        this.password = password;
    }

    public Student(String role, int classStudent, String login, String password){
        this.role = role;
        this.classStudent = classStudent;
        this.login = login;
        this.password = password;
    }

    public void PrintInfo(){
        System.out.println(firstName + " " + lastName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(int classStudent) {
        this.classStudent = classStudent;
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

    public int getResultDragonPicker() {
        return resultDragonPicker;
    }

    public void setResultDragonPicker(int resultDragonPicker) {
        this.resultDragonPicker = resultDragonPicker;
    }
}
