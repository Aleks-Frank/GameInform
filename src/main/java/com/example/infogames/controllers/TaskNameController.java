package com.example.infogames.controllers;

import com.example.infogames.audioWorker.SoundWorker;
import com.example.infogames.specialMethods.SwitchMethods;
import com.example.infogames.specialMethods.TasksMethods;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class TaskNameController implements Initializable {

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonClose;

    @FXML
    private Button buttonNext;

    @FXML
    private ImageView imageBack;

    @FXML
    private ImageView imageClose;

    @FXML
    private ImageView imageNext;

    @FXML
    private Label taskText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SwitchMethods.openWindowWordWork(buttonClose);
        SwitchMethods.openWindowWordWork(buttonNext);
        SwitchMethods.closeGameMode(buttonBack);
        TasksMethods.setDescriptions(taskText);
        SoundWorker.addSounds(buttonBack);
        SoundWorker.addSounds(buttonNext);
        SoundWorker.addSounds(buttonClose);
    }
}
