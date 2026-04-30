package com.example.infogames.globalEntity;

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

public class GlobalJSONStudent {
    public static StudentLoginDTO globalEntityLSON = new StudentLoginDTO();
    public static RestTemplate restTemplate = new RestTemplate();

    private static String url = "http://localhost:8080/student/registration";

    public static void sendJSON(Button button, String path, Label labelError){
        try {
            ResponseEntity<StudentAuth> response = restTemplate.postForEntity(url, globalEntityLSON, StudentAuth.class);
            StudentAuth student = response.getBody();
            if (student != null) {
                GlobalStudentUser.setGlobalStudent(student);
                try {
                    FXMLLoader loader = new FXMLLoader(SwitchMethods.class.getResource(path));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    scene.setFill(Color.TRANSPARENT);
                    Stage stage = (Stage) button.getScene().getWindow();
                    stage.setScene(scene);
                    stage.centerOnScreen();
                    System.out.println(student.getId());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                labelError.setText(ListMessage.loginIsClose);
            }
        } catch (ResourceAccessException e){
            labelError.setText(ListMessage.serverIsNotAnswer);
        }
    }

    public static void setGlobalEntityLSON(StudentLoginDTO globalEntityLSON) {
        GlobalJSONStudent.globalEntityLSON = globalEntityLSON;
    }
}
