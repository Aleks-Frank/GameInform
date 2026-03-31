package org.example.reader;

import org.example.entity.enumList.Alignment;

public class ReaderAlignment {
    public static Alignment readAlignment(String name){
        return switch (name) {
            case "right" -> Alignment.RIGHT;
            case "both" -> Alignment.WIDTH;
            case "center" -> Alignment.CENTER;
            default -> Alignment.LEFT;
        };
    }

    public static String readAlignmentToString(String name){
        return switch (name) {
            case "RIGHT" -> "по правому краю";
            case "WIDTH" -> "по ширине";
            case "CENTER" -> "по центру";
            default -> "по левому краю";
        };
    }

}
