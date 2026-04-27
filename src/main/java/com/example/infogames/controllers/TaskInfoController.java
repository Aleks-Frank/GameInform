package com.example.infogames.controllers;

import com.example.infogames.specialMethods.SwitchMethods;
import com.example.infogames.specialMethods.TasksMethods;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class TaskInfoController implements Initializable {

    @FXML
    private Button buttonNext;

    @FXML
    private Label countStars;

    @FXML
    private ImageView imageNext;

    @FXML
    private Label lavelName;

    @FXML
    private Label lavelNumber;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TasksMethods.setTasksInfo(lavelNumber, lavelName, countStars);
        SwitchMethods.openWordFileOnButton(buttonNext);
    }
}