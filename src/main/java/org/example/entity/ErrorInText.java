package org.example.entity;

public class ErrorInText {

    private static String text = "";
    private static Object error = null;

    public static String getText() {
        return text;
    }

    public static void setText(String text) {
        ErrorInText.text = text;
    }

    public static Object getError() {
        return error;
    }

    public static void setError(Object error) {
        ErrorInText.error = error;
    }

    public static void printInfo(){
        System.out.println("Error: " + error + "\n"
        + "Text: " + text);
    }

}
