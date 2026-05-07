package com.example.infogames.textFileWorker.comparison;

import com.example.infogames.textFileWorker.entity.ErrorInText;
import com.example.infogames.textFileWorker.entity.ParagraphSettings;

import java.util.List;

public class ConstractTextFile {

    public static Boolean comparison (List<ParagraphSettings> review, List<ParagraphSettings> correct){
        if(review.size() != correct.size()){
            ErrorInText.setError("Тексты не совпадают");
            return false;
        } else {
            return review.equals(correct);
        }
    }

}
