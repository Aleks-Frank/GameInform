package com.example.infogames.specialMethods;

import com.example.infogames.audioWorker.SoundWorker;
import com.example.infogames.entity.StudentAuth;
import com.example.infogames.entity.StudentLoginDTO;
import com.example.infogames.globalEntity.GlobalStudentUser;
import com.example.infogames.listView.ListMessage;
import javafx.scene.control.Label;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

public class SaveInfoMethods {

    public static RestTemplate restTemplate = new RestTemplate();

    private static String url = "http://localhost:8080/student/update";

    public static void sendJSON(StudentAuth studentUpdate, Label labelError){
        try {
            ResponseEntity<StudentAuth> response = restTemplate.postForEntity(url, studentUpdate, StudentAuth.class);
            StudentAuth student = response.getBody();
            if(student != null) {
                GlobalStudentUser.setGlobalStudent(student);
                labelError.setText(ListMessage.infoUpdate);
                labelError.setVisible(true);
                SoundWorker.soundsEnter();
            } else {
                labelError.setText(ListMessage.infoNotUpdate);
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
