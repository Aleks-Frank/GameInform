package org.example.reader.SpaceWorker;

import org.example.entity.TextLine;

import java.util.ArrayList;
import java.util.List;

public class SpaceWorker {

    public static List<TextLine> normalizeSpace(List<TextLine> text){
        if(text == null) return null;

        List<TextLine> result = new ArrayList<>();

        for(TextLine run : text){
            if(run != null && run.getText() != null){
                String normalizedSpace = run.getText().replaceAll("\\s+", "");
                String textSpace = run.getText();
                result.add(new TextLine(normalizedSpace, textSpace, run.getSettings()));
            }
        }

        return result;
    }

}
