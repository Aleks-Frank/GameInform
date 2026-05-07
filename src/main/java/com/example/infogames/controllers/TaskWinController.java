package com.example.infogames.controllers;

import com.example.infogames.globalEntity.GlobalTask;
import com.example.infogames.specialMethods.SwitchMethods;
import com.example.infogames.specialMethods.TasksMethods;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class TaskWinController implements Initializable {

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonNext;

    @FXML
    private Label countStars;

    @FXML
    private ImageView imageBack;

    @FXML
    private ImageView imageNext;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SwitchMethods.closeGameModeWin(buttonBack);
        TasksMethods.setCountStars(countStars);
        SwitchMethods.switchNewLevel(buttonNext, "WORD_" + (GlobalTask.globalTasks.getNumberTasks() + 1));
        System.out.println("WORD_" + (GlobalTask.globalTasks.getNumberTasks() + 1));
        System.out.println(GlobalTask.globalTasks.getNumberTasks());
    }
}
