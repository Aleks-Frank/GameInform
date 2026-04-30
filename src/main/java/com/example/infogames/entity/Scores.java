package com.example.infogames.entity;

public class Scores {

    private int lessTwo;
    private int lessThree;
    private int lessFour;
    private int countScore;

    public Scores(int lessTwo, int lessThree, int lessFour, int countScore) {
        this.lessTwo = lessTwo;
        this.lessThree = lessThree;
        this.lessFour = lessFour;
        this.countScore = countScore;
    }

    public int getLessTwo() {
        return lessTwo;
    }

    public void setLessTwo(int lessTwo) {
        this.lessTwo = lessTwo;
    }

    public int getLessThree() {
        return lessThree;
    }

    public void setLessThree(int lessThree) {
        this.lessThree = lessThree;
    }

    public int getLessFour() {
        return lessFour;
    }

    public void setLessFour(int lessFour) {
        this.lessFour = lessFour;
    }

    public int getCountScore() {
        return countScore;
    }

    public void setCountScore(int countScore) {
        this.countScore = countScore;
    }
}
