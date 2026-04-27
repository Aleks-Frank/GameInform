package com.example.infogames.controllers;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SwitchMethods.closeWindow(buttonClose);
        SwitchMethods.switchWindow(buttonBack, ListViews.LOGIN_VIEW);
        SwitchMethods.switchSettings(buttonSettings, ListViews.SETTINGS_VIEW);
        SwitchMethods.switchToWindowInfoTasks(buttonTaskOne, ListViews.TASK_INFO_VIEW, "WORD_1");
        SwitchMethods.switchToWindowInfoTasks(buttonTaskTwo, ListViews.TASK_INFO_VIEW, "WORD_2");
        SwitchMethods.switchToWindowInfoTasks(buttonTaskThree, ListViews.TASK_INFO_VIEW, "WORD_3");
        SwitchMethods.switchToWindowInfoTasks(buttonTaskFour, ListViews.TASK_INFO_VIEW, "WORD_4");
        SwitchMethods.switchToWindowInfoTasks(buttonTaskFive, ListViews.TASK_INFO_VIEW, "WORD_5");
        SwitchMethods.switchToWindowInfoTasks(buttonTaskSix, ListViews.TASK_INFO_VIEW, "WORD_6");
        SwitchMethods.switchToWindowInfoTasks(buttonTaskSeven, ListViews.TASK_INFO_VIEW, "WORD_7");
        SwitchMethods.switchToWindowInfoTasks(buttonTaskEight, ListViews.TASK_INFO_VIEW, "WORD_8");
        SwitchMethods.switchToWindowInfoTasks(buttonTaskNine, ListViews.TASK_INFO_VIEW, "WORD_9");
        SwitchMethods.switchToWindowInfoTasks(buttonTaskTen, ListViews.TASK_INFO_VIEW, "WORD_10");
        SwitchMethods.switchToWindowInfoTasks(buttonTaskEleven, ListViews.TASK_INFO_VIEW, "WORD_11");
        SwitchMethods.switchToWindowInfoTasks(buttonTaskTwelve, ListViews.TASK_INFO_VIEW, "WORD_12");
    }
}