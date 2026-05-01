package com.example.infogames.globalEntity;

import com.example.infogames.audioWorker.SoundWorker;
import com.example.infogames.entity.LoginJSONRequest;
import com.example.infogames.entity.StudentAuth;
import com.example.infogames.entity.StudentLoginDTO;
import com.example.infogames.listView.ListMessage;
import com.example.infogames.specialMethods.SwitchMethods;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class GlobalJSONLogin {
    public static LoginJSONRequest globalLogin = new LoginJSONRequest();
    public static RestTemplate restTemplate = new RestTemplate();

    private static String url = "http://localhost:8080/student/login";

    public static void sendJSON(Button button, String path, Label labelError){
        try {
            ResponseEntity<StudentAuth> response = restTemplate.postForEntity(url, globalLogin, StudentAuth.class);
            StudentAuth student = response.getBody();
            if(student != null) {
                GlobalStudentUser.setGlobalStudent(student);
                SoundWorker.soundsEnter();
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
            } else {
                labelError.setText(ListMessage.studentNotFound);
                labelError.setVisible(true);
                SoundWorker.soundsError();
            }
        } catch (ResourceAccessException e) {
            labelError.setText(ListMessage.serverIsNotAnswer);
            labelError.setVisible(true);
            SoundWorker.soundsError();
        }
    }
}
