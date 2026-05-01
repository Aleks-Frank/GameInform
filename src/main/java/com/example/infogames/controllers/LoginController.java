package com.example.infogames.controllers;

import com.example.infogames.audioWorker.SoundWorker;
import com.example.infogames.listView.ListViews;
import com.example.infogames.specialMethods.LoginMethods;
import com.example.infogames.specialMethods.SwitchMethods;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button buttonClose;

    @FXML
    private Button buttonEnter;

    @FXML
    private Button buttonRegister;

    @FXML
    private ImageView imageClose;

    @FXML
    private ImageView imageEnter;

    @FXML
    private ImageView imageRegister;

    @FXML
    private TextField inputLogin;

    @FXML
    private TextField inputPassword;

    @FXML
    private Label labelError;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelError.setVisible(false);
        SwitchMethods.closeWindow(buttonClose);
//        SwitchMethods.switchWindow(buttonEnter, ListViews.LEVELS_VIEW);
        SwitchMethods.switchWindow(buttonRegister, ListViews.REGISTRATION_LIST_ONE_VIEW);
        LoginMethods.saveInfoToLogin(buttonEnter, ListViews.LEVELS_VIEW, inputLogin, inputPassword, labelError);
        SoundWorker.addSoundsLogin(buttonEnter);
        SoundWorker.addSounds(buttonRegister);
        SoundWorker.addSounds(buttonClose);
    }
}