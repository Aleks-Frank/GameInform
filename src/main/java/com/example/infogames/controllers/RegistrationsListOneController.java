package com.example.infogames.controllers;

import com.example.infogames.listView.ListViews;
import com.example.infogames.specialMethods.SwitchMethods;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationsListOneController implements Initializable {

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
    private TextField inputClass;

    @FXML
    private TextField inputName;

    @FXML
    private TextField inputSchool;

    @FXML
    private TextField inputSurname;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SwitchMethods.closeWindow(buttonClose);
        SwitchMethods.switchWindow(buttonBack, ListViews.LOGIN_VIEW);
        SwitchMethods.switchWindow(buttonNext, ListViews.REGISTRATION_LIST_TWO_VIEW);
    }
}
