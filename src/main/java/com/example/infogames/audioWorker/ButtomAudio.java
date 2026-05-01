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
        updateButtonStyle(image);
        button.setOnAction(actionEvent -> {
            if(isSoundWork == true){
                isSoundWork = false;
                updateButtonStyle(image);
            } else {
                isSoundWork = true;
                updateButtonStyle(image);
            }
        });
    }

    private static void updateButtonStyle(ImageView image) {
        image.getStyleClass().removeAll("image-view-button-sound", "image-view-button-mute");

        if (isSoundWork) {
            image.getStyleClass().add("image-view-button-sound");
        } else {
            image.getStyleClass().add("image-view-button-mute");
        }
    }

}
