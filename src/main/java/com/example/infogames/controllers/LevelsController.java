package com.example.infogames.controllers;

import com.example.infogames.audioWorker.SoundWorker;
import com.example.infogames.globalEntity.GlobalStudentUser;
import com.example.infogames.listView.ListViews;
import com.example.infogames.specialMethods.SwitchImage;
import com.example.infogames.specialMethods.SwitchMethods;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class LevelsController implements Initializable {

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonClose;

    @FXML
    private Button buttonSettings;

    @FXML
    private Button buttonTaskEight;

    @FXML
    private Button buttonTaskEleven;

    @FXML
    private Button buttonTaskFive;

    @FXML
    private Button buttonTaskFour;

    @FXML
    private Button buttonTaskNine;

    @FXML
    private Button buttonTaskOne;

    @FXML
    private Button buttonTaskSeven;

    @FXML
    private Button buttonTaskSix;

    @FXML
    private Button buttonTaskTen;

    @FXML
    private Button buttonTaskThree;

    @FXML
    private Button buttonTaskTwelve;

    @FXML
    private Button buttonTaskTwo;

    @FXML
    private Label countStars;

    @FXML
    private ImageView imageBack;

    @FXML
    private ImageView imageSettings;

    @FXML
    private ImageView imageTaskEight;

    @FXML
    private ImageView imageTaskEleven;

    @FXML
    private ImageView imageTaskFive;

    @FXML
    private ImageView imageTaskFour;

    @FXML
    private ImageView imageTaskNine;

    @FXML
    private ImageView imageTaskOne;

    @FXML
    private ImageView imageTaskSeven;

    @FXML
    private ImageView imageTaskSix;

    @FXML
    private ImageView imageTaskTen;

    @FXML
    private ImageView imageTaskThree;

    @FXML
    private ImageView imageTaskTwelve;

    @FXML
    private ImageView imageTaskTwo;

    @FXML
    private ImageView imageClose;

    @FXML
    private ImageView prefon;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SwitchMethods.closeWindow(buttonClose);
        SwitchMethods.logoutBottom(buttonBack);
        SwitchMethods.switchSettings(buttonSettings, ListViews.SETTINGS_VIEW, prefon);
        SwitchMethods.switchToWindowInfoTasks(buttonTaskOne, ListViews.TASK_INFO_VIEW, "WORD_1", prefon);
        SwitchMethods.switchToWindowInfoTasks(buttonTaskTwo, ListViews.TASK_INFO_VIEW, "WORD_2", prefon);
        SwitchMethods.switchToWindowInfoTasks(buttonTaskThree, ListViews.TASK_INFO_VIEW, "WORD_3", prefon);
        SwitchMethods.switchToWindowInfoTasks(buttonTaskFour, ListViews.TASK_INFO_VIEW, "WORD_4", prefon);
        SwitchMethods.switchToWindowInfoTasks(buttonTaskFive, ListViews.TASK_INFO_VIEW, "WORD_5", prefon);
        SwitchMethods.switchToWindowInfoTasks(buttonTaskSix, ListViews.TASK_INFO_VIEW, "WORD_6", prefon);
        SwitchMethods.switchToWindowInfoTasks(buttonTaskSeven, ListViews.TASK_INFO_VIEW, "WORD_7", prefon);
        SwitchMethods.switchToWindowInfoTasks(buttonTaskEight, ListViews.TASK_INFO_VIEW, "WORD_8", prefon);
        SwitchMethods.switchToWindowInfoTasks(buttonTaskNine, ListViews.TASK_INFO_VIEW, "WORD_9", prefon);
        SwitchMethods.switchToWindowInfoTasks(buttonTaskTen, ListViews.TASK_INFO_VIEW, "WORD_10", prefon);
        SwitchMethods.switchToWindowInfoTasks(buttonTaskEleven, ListViews.TASK_INFO_VIEW, "WORD_11", prefon);
        SwitchMethods.switchToWindowInfoTasks(buttonTaskTwelve, ListViews.TASK_INFO_VIEW, "WORD_12", prefon);
        countStars.setText(String.valueOf(GlobalStudentUser.getCountCoins()));
        SoundWorker.addSounds(buttonTaskOne);
        SoundWorker.addSounds(buttonTaskTwo);
        SoundWorker.addSounds(buttonTaskThree);
        SoundWorker.addSounds(buttonTaskFour);
        SoundWorker.addSounds(buttonTaskFive);
        SoundWorker.addSounds(buttonTaskSix);
        SoundWorker.addSounds(buttonTaskSeven);
        SoundWorker.addSounds(buttonTaskEight);
        SoundWorker.addSounds(buttonTaskNine);
        SoundWorker.addSounds(buttonTaskTen);
        SoundWorker.addSounds(buttonTaskEleven);
        SoundWorker.addSounds(buttonTaskTwelve);
        SoundWorker.addSounds(buttonSettings);
        SoundWorker.addSounds(buttonBack);
        SoundWorker.addSounds(buttonClose);
        System.out.println(GlobalStudentUser.getCountCoins());
        System.out.println(GlobalStudentUser.getFirstName());
    }
}