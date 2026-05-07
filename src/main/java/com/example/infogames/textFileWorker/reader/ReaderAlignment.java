package com.example.infogames.textFileWorker.reader;

public class ReaderAlignment {
    public static String readAlignmentToString(String name){
        switch (name) {
            case "RIGHT":
                return "по правому краю";
            case "WIDTH":
                return "по ширине";
            case "CENTER":
                return "по центру";
            default:
                return "по левому краю";
        }
    }
}
