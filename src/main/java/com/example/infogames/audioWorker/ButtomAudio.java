package com.example.infogames.audioWorker;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;


public class ButtomAudio {
    private static Boolean isSoundWork = true;

    public static Boolean getIsSoundWork() {
        return isSoundWork;
    }

    public static void setIsSoundWork(Boolean isSoundWork) {
        ButtomAudio.isSoundWork = isSoundWork;
    }

    public static void setAudioSettings(Button button, ImageView image){
        button.setOnAction(actionEvent -> {
            if(isSoundWork == true){
                image.getStyleClass().add("image-view-button-mute");
                image.getStyleClass().remove("image-view-button-sound");
                isSoundWork = false;
            } else {
                image.getStyleClass().add("image-view-button-sound");
                image.getStyleClass().remove("image-view-button-mute");
                isSoundWork = true;
            }
        });
    }

}
