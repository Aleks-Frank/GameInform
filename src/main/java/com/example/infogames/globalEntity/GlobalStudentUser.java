package com.example.infogames.globalEntity;

import com.example.infogames.entity.Student;

public class GlobalStudentUser {
    public static Student globalStudent = new Student("Oleg", "Legkin", "stud", 0, " ", "olegLeg", "12345678");

    public static String getFirstName(){
        return globalStudent.getFirstName();
    }

    public static String getLastName(){
        return globalStudent.getLastName();
    }

    public static void setCountCoins(int countCoins){
        globalStudent.setCountCoins(countCoins);
    }

    public static int getCountCoins(){
        return globalStudent.getCountCoins();
    }
}
