package com.example.infogames.textFileWorker.parse;

import com.example.infogames.textFileWorker.entity.ParagraphSettings;
import com.example.infogames.textFileWorker.entity.TextLine;
import com.example.infogames.textFileWorker.reader.ReaderTextFile;

import java.io.File;
import java.util.List;

public class ParseTextFile {
    public static List<ParagraphSettings> parse(String filePath) {
        ReaderTextFile reader = new ReaderTextFile(new File(filePath));
        return reader.parseDocument();
    }

    public static void PrintInfo(List<ParagraphSettings> paragraph){
        for(ParagraphSettings p : paragraph){
            System.out.println(p.getRedLine());
            System.out.println(p.getAlignment());
            for(TextLine text : p.getParagraph()){
                System.out.println(text.getText());
                System.out.println(text.getSettings().toString());
            }
        }
    }
}
