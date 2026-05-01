package com.example.infogames.audioWorker;

import javafx.scene.control.Button;

public class SoundWorker {
    public static void addSounds(Button button) {
        SoundManager soundManager = SoundManager.getInstance();

        button.setOnMouseEntered(e -> {
            if (ButtomAudio.getIsSoundWork()) {
                soundManager.playHoverSound();
            }
        });

        button.setOnMousePressed(e -> {
            if (ButtomAudio.getIsSoundWork()) {
                soundManager.playClickSound();
            }
        });
    }

    public static void addSoundsLogin(Button button) {
        SoundManager soundManager = SoundManager.getInstance();

        button.setOnMouseEntered(e -> {
            if (ButtomAudio.getIsSoundWork()) {
                soundManager.playHoverSound();
            }
        });
    }

    public static void soundsError() {
        SoundManager soundManager = SoundManager.getInstance();
        if (ButtomAudio.getIsSoundWork()) {
            soundManager.playErrorSound();
        }
    }

    public static void soundsEnter() {
        SoundManager soundManager = SoundManager.getInstance();
        if (ButtomAudio.getIsSoundWork()) {
            soundManager.playCorrectSound();
        }
    }

    public static void soundsClick() {
        SoundManager soundManager = SoundManager.getInstance();
        if (ButtomAudio.getIsSoundWork()) {
            soundManager.playClickSound();
        }
    }

}
