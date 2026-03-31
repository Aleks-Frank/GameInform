package com.example.infogames.specialMethods;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SwitchMethods {

    /**Метод для кнопки закрытия*/
    public static void closeWindow(Button button){
        button.setOnAction(event -> {
            Stage stage = (Stage) button.getScene().getWindow();
            stage.close();
        });
    }

    /**Метод для перемещения между окнами*/
    public static void switchWindow(Button button, String path){
        button.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(SwitchMethods.class.getResource(path));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                scene.setFill(Color.TRANSPARENT);
                Stage stage = (Stage) button.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**Метод для открытия настроек*/
    public static void switchSettings(Button button, String path) {
        button.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(SwitchMethods.class.getResource(path));
                Parent newRoot = loader.load();
                Stage settingsStage = new Stage();
                settingsStage.initOwner(StageMethods.getPrimaryStage());
                settingsStage.initStyle(StageStyle.UNDECORATED);
                settingsStage.initModality(Modality.WINDOW_MODAL);
                Scene scene = new Scene(newRoot);
                scene.setFill(Color.TRANSPARENT);
                settingsStage.setScene(scene);
                settingsStage.initStyle(StageStyle.TRANSPARENT);

                StageMethods.setSettingStage(settingsStage);
                settingsStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**Метод для закрытия настроек*/
    public static void switchFromSettingsToTheWindow(Button button) {
        button.setOnAction(event -> {
            StageMethods.getSettingStage().close();
        });
    }

    

}
