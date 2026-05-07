package com.example.infogames.controllers;


import com.example.infogames.specialMethods.TasksMethods;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class TaskErrorController implements Initializable {

    @FXML
    private Label Error;

    @FXML
    private Label textError;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TasksMethods.setError(Error, textError);
    }
}
