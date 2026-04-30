package com.example.infogames.controllers;

import com.example.infogames.specialMethods.LoadInfoMethods;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ScoresController implements Initializable {

    @FXML
    private Button buttonClose;

    @FXML
    private ImageView imageClose;

    @FXML
    private Label labelScoreInfo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoadInfoMethods.loadScoresInfo(labelScoreInfo);
    }
}