package com.example.infogames.specialMethods;

import com.example.infogames.audioWorker.SoundWorker;
import com.example.infogames.entity.StudentLoginDTO;
import com.example.infogames.globalEntity.GlobalJSONStudent;
import com.example.infogames.listView.ListMessage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.util.Objects;

public class RegistrationMethods {
    public static void saveInfoToGlobalJSONStudent(Button button, String path,
                                                   TextField inputClass,
                                                   TextField inputSchool,
                                                   TextField inputName,
                                                   TextField inputSurname,
                                                   Label labelError){
        button.setOnAction( event -> {
            if (GlobalJSONStudent.globalEntityLSON == null) {
                GlobalJSONStudent.globalEntityLSON = new StudentLoginDTO();
            }
            if(Objects.equals(inputClass.getText(), "") ||
                    Objects.equals(inputSchool.getText(), "") ||
                    Objects.equals(inputName.getText(), "") ||
                    Objects.equals(inputSurname.getText(), "")) {
                labelError.setText(ListMessage.formNotFull);
                SoundWorker.soundsError();
            } else {
                GlobalJSONStudent.globalEntityLSON.setFirstName(inputName.getText().trim());
                GlobalJSONStudent.globalEntityLSON.setLastName(inputSurname.getText().trim());
                GlobalJSONStudent.globalEntityLSON.setStudentNumber(Integer.parseInt(inputClass.getText().trim()));
                GlobalJSONStudent.globalEntityLSON.setSchool(inputSchool.getText().trim());
                GlobalJSONStudent.globalEntityLSON.setRole("student");
                SoundWorker.soundsClick();
                try{
                    FXMLLoader loader = new FXMLLoader(SwitchMethods.class.getResource(path));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    scene.setFill(Color.TRANSPARENT);
                    Stage stage = (Stage) button.getScene().getWindow();
                    stage.setScene(scene);
                    stage.centerOnScreen();
                    System.out.println(GlobalJSONStudent.globalEntityLSON.getFirstName());
                    System.out.println(GlobalJSONStudent.globalEntityLSON.getStudentNumber());
                } catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        }
        );
    }

    public static void savePasswordAndLoginToGlobalJSONStudent(Button button, String path,
                                                   TextField inputPassword,
                                                   TextField inputLogin, Label labelError){
        button.setOnAction( event -> {
            if(Objects.equals(inputPassword.getText(), "") || Objects.equals(inputLogin.getText(), "")) {
                labelError.setText(ListMessage.formNotFull);
                SoundWorker.soundsError();
            } else {
                GlobalJSONStudent.globalEntityLSON.setPassword(inputPassword.getText().trim());
                GlobalJSONStudent.globalEntityLSON.setLogin(inputLogin.getText().trim());
                GlobalJSONStudent.sendJSON(button, path, labelError);
            }
        }
        );
    }

}
