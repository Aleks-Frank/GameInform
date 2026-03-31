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

public class RegistrationsListTwoController implements Initializable {

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonClose;

    @FXML
    private Button buttonLogout;

    @FXML
    private ImageView imageBack;

    @FXML
    private ImageView imageClose;

    @FXML
    private ImageView imageLogout;

    @FXML
    private TextField inputLogin;

    @FXML
    private TextField inputPassword;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SwitchMethods.closeWindow(buttonClose);
        SwitchMethods.switchWindow(buttonBack, ListViews.REGISTRATION_LIST_ONE_VIEW);
        SwitchMethods.switchWindow(buttonLogout, ListViews.LEVELS_VIEW);
    }
}

