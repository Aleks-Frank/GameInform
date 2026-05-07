package com.example.infogames.controllers;

import com.example.infogames.audioWorker.SoundWorker;
import com.example.infogames.checkerMethods.CheckerMethods;
import com.example.infogames.specialMethods.SwitchMethods;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class CheckerController implements Initializable {

    @FXML
    private Button buttonChecker;

    @FXML
    private Button buttonShowTask;

    @FXML
    private ImageView imageChecker;

    @FXML
    private ImageView imageShowTask;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SwitchMethods.openTasksStage(buttonShowTask);
        SoundWorker.addSounds(buttonShowTask);
        CheckerMethods.checkFile(buttonChecker);
    }
}
