package com.example.infogames.globalEntity;

import com.example.infogames.entity.Student;

public class GlobalStudentUser {
    public static Student globalStudent = null;

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
