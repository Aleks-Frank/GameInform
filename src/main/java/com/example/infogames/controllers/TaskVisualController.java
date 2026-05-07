package com.example.infogames.controllers;

import com.example.infogames.specialMethods.TasksMethods;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ResourceBundle;

public class TaskVisualController implements Initializable {

    @FXML
    private TextFlow taskText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TasksMethods.displayParagraphsInTextFlow(taskText);
    }
}
