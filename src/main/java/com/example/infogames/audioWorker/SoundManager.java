package com.example.infogames.audioWorker;

import javafx.scene.media.AudioClip;

import java.util.HashMap;
import java.util.Map;

public class SoundManager {

    private static SoundManager instance;
    private Map<String, AudioClip> soundCache;
    private double volume = 0.5;

    private SoundManager() {
        soundCache = new HashMap<>();
        loadAllSounds();
    }

    public static SoundManager getInstance() {
        if (instance == null) {
            instance = new SoundManager();
        }
        return instance;
    }

    private void loadAllSounds() {
        loadSound("click-hover", "/audio/click-hover.mp3");
        loadSound("click", "/audio/click-pre.mp3");
        loadSound("correct", "/audio/correct.mp3");
        loadSound("error", "/audio/error.mp3");
        loadSound("level", "/audio/level.mp3");
        loadSound("win", "/audio/win.mp3");
    }

    private void loadSound(String name, String path) {
        try {
            AudioClip sound = new AudioClip(getClass().getResource(path).toString());
            sound.setVolume(volume);
            soundCache.put(name, sound);
        } catch (Exception e) {
            System.err.println("Failed to load sound: " + path);
            e.printStackTrace();
        }
    }

    public void playSound(String soundName) {
        if (!ButtomAudio.getIsSoundWork()) return;

        AudioClip sound = soundCache.get(soundName);
        if (sound != null) {
            sound.play();
        }
    }

    public void playHoverSound() {
        playSound("click-hover");
    }

    public void playClickSound() {
        playSound("click");
    }

    public void playCorrectSound() {
        playSound("correct");
    }

    public void playErrorSound() {
        playSound("error");
    }

    public void playWinSound() {
        playSound("win");
    }

    public void playLevelSound() {
        playSound("level");
    }

}
