package org.example.comparison;

import org.example.entity.ParagraphSettings;

import java.util.List;

public class ConstractTextFile {

    public static Boolean comparison (List<ParagraphSettings> review, List<ParagraphSettings> correct){
        return review.equals(correct);
    }

}
