package com.example.infogames.checkerMethods;

import com.example.infogames.globalEntity.GlobalStudentUser;
import com.example.infogames.globalEntity.GlobalTask;
import com.example.infogames.specialMethods.SwitchMethods;
import com.example.infogames.textFileWorker.comparison.ConstractTextFile;
import com.example.infogames.textFileWorker.entity.ErrorInText;
import com.example.infogames.textFileWorker.entity.ParagraphSettings;
import com.example.infogames.textFileWorker.jsonWorker.ParseJSON;
import com.example.infogames.textFileWorker.parse.ParseTextFile;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class CheckerMethods {

    public static void checkFile(Button button){
        button.setOnAction(actionEvent -> {
            List<ParagraphSettings> review = ParseTextFile.parse(GlobalStudentUser.urlFile);
            List<ParagraphSettings> correct;
            if(GlobalTask.paragraph == null) {
                correct = ParseJSON.parseJsonToParagraphList(GlobalTask.globalTasks.getJson());
                GlobalTask.paragraph = correct;
            } else {
                correct = GlobalTask.paragraph;
            }
            System.out.println("review: " + ParseJSON.convertToJSONSToString(review));
            System.out.println("correct: " + GlobalTask.globalTasks.getJson());
            System.out.println(ConstractTextFile.comparison(review, correct));
            if(ConstractTextFile.comparison(review, correct)){
                SwitchMethods.switchWinWindow();
                addStars();
            } else {
                SwitchMethods.reloadWindowError();
                ErrorInText.printInfo();
            }
        });
    }

    private static void addStars(){
        GlobalStudentUser.globalStudent.setCountCoins(GlobalStudentUser.globalStudent.getCountCoins() + GlobalTask.globalTasks.getCountStars());
    }

}
