package com.example.infogames.globalEntity;

import com.example.infogames.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class GlobalJSONStudent {
    public static Student globalEntityLSON = new Student();
    public static RestTemplate restTemplate = new RestTemplate();

    private static String url = "http://localhost:8080/student/registration";

    public static Boolean sendJSON(){
        ResponseEntity<Boolean> response = restTemplate.postForEntity(url, globalEntityLSON, Boolean.class);
        return response.getBody();
    }

}
