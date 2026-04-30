package com.example.infogames.controllers;

import com.example.infogames.listView.ListViews;
import com.example.infogames.specialMethods.LoadInfoMethods;
import com.example.infogames.specialMethods.SaveInfoMethods;
import com.example.infogames.specialMethods.SwitchMethods;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateInfoController implements Initializable {

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonClose;

    @FXML
    private Button buttonSave;

    @FXML
    private ImageView imageBack;

    @FXML
    private ImageView imageClose;

    @FXML
    private ImageView imageSave;

    @FXML
    private TextField inputClass;

    @FXML
    private TextField inputLogin;

    @FXML
    private TextField inputName;

    @FXML
    private TextField inputPassword;

    @FXML
    private TextField inputSchool;

    @FXML
    private TextField inputSurname;

    @FXML
    private Label labelError;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SwitchMethods.closeWindow(buttonClose);
        LoadInfoMethods.loadTextFieldForEditForm(inputName, inputSurname, inputClass, inputSchool, inputLogin);
        SwitchMethods.switchWindow(buttonBack, ListViews.LEVELS_VIEW);
        SwitchMethods.saveNewInfoStudent(buttonSave, labelError, inputName, inputSurname, inputClass, inputSchool, inputLogin, inputPassword);
    }
}
