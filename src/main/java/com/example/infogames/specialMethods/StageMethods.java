package com.example.infogames.specialMethods;

import javafx.stage.Stage;

public class StageMethods {
    private static Stage primaryStage;

    private static Stage settingStage;

    private static Stage infoTasksSave;

    private static Stage currectSaveStage;

    private static Stage resultSaveStage;

    private static Stage winSaveStage;

    private static Stage failSaveStage;

    private static Stage settingStageGame;

    private static Stage failGameEnterSaveStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        StageMethods.primaryStage = primaryStage;
    }

    public static Stage getSettingStage() {
        return settingStage;
    }

    public static void setSettingStage(Stage settingStage) {
        StageMethods.settingStage = settingStage;
    }

    public static Stage getInfoTasksSave() {
        return infoTasksSave;
    }

    public static void setInfoTasksSave(Stage infoTasksSave) {
        StageMethods.infoTasksSave = infoTasksSave;
    }

    public static Stage getCurrectSaveStage() {
        return currectSaveStage;
    }

    public static void setCurrectSaveStage(Stage currectSaveStage) {
        StageMethods.currectSaveStage = currectSaveStage;
    }

    public static Stage getResultSaveStage() {
        return resultSaveStage;
    }

    public static void setResultSaveStage(Stage resultSaveStage) {
        StageMethods.resultSaveStage = resultSaveStage;
    }

    public static Stage getWinSaveStage() {
        return winSaveStage;
    }

    public static void setWinSaveStage(Stage winSaveStage) {
        StageMethods.winSaveStage = winSaveStage;
    }

    public static Stage getFailSaveStage() {
        return failSaveStage;
    }

    public static void setFailSaveStage(Stage failSaveStage) {
        StageMethods.failSaveStage = failSaveStage;
    }

    public static Stage getSettingStageGame() {
        return settingStageGame;
    }

    public static void setSettingStageGame(Stage settingStageGame) {
        StageMethods.settingStageGame = settingStageGame;
    }

    public static Stage getFailGameEnterSaveStage() {
        return failGameEnterSaveStage;
    }

    public static void setFailGameEnterSaveStage(Stage failGameEnterSaveStage) {
        StageMethods.failGameEnterSaveStage = failGameEnterSaveStage;
    }
}
