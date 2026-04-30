package com.example.infogames.globalEntity;

import com.example.infogames.entity.StudentAuth;
import com.example.infogames.entity.StudentLoginDTO;

public class GlobalStudentUser {
    public static StudentAuth globalStudent = new StudentAuth();

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

    public static void setGlobalStudent(StudentAuth globalStudent) {
        GlobalStudentUser.globalStudent = globalStudent;
    }

}
