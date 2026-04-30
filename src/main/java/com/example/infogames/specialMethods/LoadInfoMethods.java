package com.example.infogames.specialMethods;

import com.example.infogames.entity.Scores;
import com.example.infogames.globalEntity.GlobalJSONStudent;
import com.example.infogames.globalEntity.GlobalScore;
import com.example.infogames.globalEntity.GlobalStudentUser;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.MessageFormat;

public class LoadInfoMethods {

    public static void loadTextField(TextField name, TextField surname, TextField classStudent, TextField school){
        if(GlobalJSONStudent.globalEntityLSON != null) {
            name.setText(GlobalJSONStudent.globalEntityLSON.getFirstName());
            surname.setText(GlobalJSONStudent.globalEntityLSON.getLastName());
            classStudent.setText(GlobalJSONStudent.globalEntityLSON.getStudentNumber() == 0 ? "" : String.valueOf(GlobalJSONStudent.globalEntityLSON.getStudentNumber()));
            school.setText(GlobalJSONStudent.globalEntityLSON.getSchool());
        } else {
            name.setText("");
            surname.setText("");
            classStudent.setText("");
            school.setText("");
        }

    }

    public static void loadTextField(TextField login, TextField password){
        login.setText(GlobalJSONStudent.globalEntityLSON.getLogin() == null ? "" : GlobalJSONStudent.globalEntityLSON.getLogin());
        password.setText(GlobalJSONStudent.globalEntityLSON.getPassword() == null ? "" : GlobalJSONStudent.globalEntityLSON.getPassword());
    }

    public static void loadTextFieldForEditForm(TextField name, TextField surname, TextField classStudent, TextField school, TextField login){
        name.setText(GlobalStudentUser.globalStudent.getFirstName());
        surname.setText(GlobalStudentUser.globalStudent.getLastName());
        classStudent.setText(String.valueOf(GlobalStudentUser.globalStudent.getStudentNumber()));
        school.setText(GlobalStudentUser.globalStudent.getSchool());
        login.setText(GlobalStudentUser.globalStudent.getLogin());
    }

    public static void loadScoresInfo(Label label){
        label.setText(MessageFormat.format("Максимум баллов: {0}\n " +
                "\nМеньше {1} баллов - 2\n " +
                "От {1} до {2} баллов - 3\n " +
                "От {2} до {3} баллов - 4\n " +
                "Больше {3} баллов - 5\n " +
                "\n Твоя оценка: {4}", GlobalScore.scores.getCountScore(),
                GlobalScore.scores.getLessTwo(),
                GlobalScore.scores.getLessThree(),
                GlobalScore.scores.getLessFour(),
                convertScoreToBall(GlobalStudentUser.globalStudent.getCountCoins())));
    }

    private static int convertScoreToBall(int score){
        if(score < GlobalScore.scores.getLessTwo() && score > 0){
            return 2;
        } else if (score > GlobalScore.scores.getLessTwo() && score < GlobalScore.scores.getLessThree()) {
            return 3;
        } else if (score > GlobalScore.scores.getLessThree() && score < GlobalScore.scores.getLessFour()) {
            return 3;
        } else if (score > GlobalScore.scores.getLessFour() && score < GlobalScore.scores.getCountScore()) {
            return 5;
        } else {
            return 0;
        }
    }

}
