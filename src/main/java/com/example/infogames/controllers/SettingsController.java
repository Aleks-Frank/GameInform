package com.example.infogames.controllers;

import com.example.infogames.audioWorker.ButtomAudio;
import com.example.infogames.audioWorker.SoundManager;
import com.example.infogames.audioWorker.SoundWorker;
import com.example.infogames.listView.ListViews;
import com.example.infogames.specialMethods.SwitchMethods;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    @FXML
    private Button buttonClose;

    @FXML
    private Button buttonEdit;

    @FXML
    private Button buttonInfo;

    @FXML
    private Button buttonLogout;

    @FXML
    private Button buttonSound;

    @FXML
    private ImageView imageClose;

    @FXML
    private ImageView imageInfo;

    @FXML
    private ImageView imageLogout;

    @FXML
    private ImageView imageSound;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SwitchMethods.switchWindowToSettings(buttonEdit, ListViews.UPDATE_INFO_VIEW);
        SwitchMethods.logoutBottomToSettings(buttonLogout);
        SwitchMethods.switchSettingsToScoreMenu(buttonInfo);
        ButtomAudio.setAudioSettings(buttonSound, imageSound);
        SoundWorker.addSounds(buttonInfo);
        SoundWorker.addSounds(buttonEdit);
        SoundWorker.addSounds(buttonSound);
        SoundWorker.addSounds(buttonLogout);
    }
}