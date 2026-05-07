package com.example.infogames.textFileWorker.entity;

import com.example.infogames.textFileWorker.reader.ReaderAlignment;

import java.util.List;
import java.util.Objects;

public class ParagraphSettings {
    private List<TextLine> paragraph;
    private String alignment = "LEFT";
    private Boolean isRedLine = false;

    public ParagraphSettings() {
    }

    public ParagraphSettings(List<TextLine> paragraph, String alignment, Boolean isRedLine) {
        this.paragraph = paragraph;
        this.alignment = alignment;
        this.isRedLine = isRedLine;
    }

    public List<TextLine> getParagraph() {
        return paragraph;
    }

    public void setParagraph(List<TextLine> paragraph) {
        this.paragraph = paragraph;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public Boolean getRedLine() {
        return isRedLine;
    }

    public void setRedLine(Boolean redLine) {
        isRedLine = redLine;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("0");
        if (o == null || getClass() != o.getClass()) return false;
        ParagraphSettings that = (ParagraphSettings) o;
        System.out.println("01");
        if(!Objects.equals(alignment, that.alignment)){
            System.out.println("1");
            ErrorInText.setError("Выравни " + ReaderAlignment.readAlignmentToString(String.valueOf(that.alignment)));
            ErrorInText.setText(((ParagraphSettings) o).paragraph.get(0).getTextSpace());
            System.out.println("Ошибка в выравнивание");
            return false;
        } else if(isRedLine != that.isRedLine){
            System.out.println("2");
            ErrorInText.setError("Нет красной строки");
            ErrorInText.setText(((ParagraphSettings) o).paragraph.get(0).getTextSpace());
            System.out.println("Ошибка в красной строке");
            return false;
        } else if (paragraph.size() != that.paragraph.size()) {
            System.out.println("3");
            System.out.println(paragraph.size());
            for(TextLine p : paragraph){
                System.out.println(p.getTextSpace().toString());
            }
            System.out.println(that.paragraph.size());
            for(TextLine p : that.paragraph){
                System.out.println(p.getTextSpace().toString());
            }
            ErrorInText.setError("Тексты не совпадают");
            ErrorInText.setText(((ParagraphSettings) o).paragraph.get(0).getTextSpace());
            System.out.println("Ошибка в тексте");
            return false;
        } else {
            System.out.println("4");
            for(int i = 0; i < paragraph.size(); i++){
                if(!paragraph.get(i).equals(that.paragraph.get(i))){
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(alignment, isRedLine);
    }
}
