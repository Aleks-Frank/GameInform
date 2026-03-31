package org.example;

import org.example.comparison.ConstractTextFile;
import org.example.entity.ErrorInText;
import org.example.parse.ParseTextFile;

public class Main {
    static void main() {
        var correct = ParseTextFile.parse("C:/Users/SACHA/OneDrive/Desktop/correct.docx");
        var review = ParseTextFile.parse("C:/Users/SACHA/OneDrive/Desktop/review.docx");
        System.out.println(ConstractTextFile.comparison(review, correct));
        ErrorInText.printInfo();
    }
}
