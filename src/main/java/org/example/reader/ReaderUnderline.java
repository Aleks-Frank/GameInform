package org.example.reader;

import org.example.entity.enumList.Underline;

public class ReaderUnderline {

    public static Underline readUnderline(String name){
        return switch (name) {
            case "double" -> Underline.DOUBLEUNDERLINE;
            case "thick" -> Underline.BOLDLINE;
            case "wave" -> Underline.WAVELINE;
            default -> Underline.UNDERLINE;
        };
    }

}
