package com.example.infogames.textFileWorker.jsonWorker;

import com.example.infogames.textFileWorker.entity.ParagraphSettings;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ParseJSON {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String convertToJSONSToString(List<ParagraphSettings> paragraphs){
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(paragraphs));
        return objectMapper.writeValueAsString(paragraphs);
    }

    public static List<ParagraphSettings> parseJsonToParagraphList(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, new TypeReference<List<ParagraphSettings>>() {});
        } catch (Exception e) {
            System.err.println("Ошибка парсинга JSON: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
