package org.example.entity;

import org.example.entity.enumList.Alignment;
import org.example.reader.ReaderAlignment;

import java.util.List;
import java.util.Objects;

public class ParagraphSettings {
    private List<TextLine> paragraph;
    private Alignment alignment = Alignment.LEFT;
    private Boolean isRedLine = false;

    public ParagraphSettings() {
    }

    public ParagraphSettings(List<TextLine> paragraph, Alignment alignment, Boolean isRedLine) {
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

    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
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
        if (o == null || getClass() != o.getClass()) return false;
        ParagraphSettings that = (ParagraphSettings) o;
        if(alignment != that.alignment){
            ErrorInText.setError("Выравнивание имеет вид " + ReaderAlignment.readAlignmentToString(String.valueOf(alignment))
                    + ",а должно быть " + ReaderAlignment.readAlignmentToString(String.valueOf(that.alignment)));
            ErrorInText.setText(((ParagraphSettings) o).paragraph.getFirst().getTextSpace());
            System.out.println("Ошибка в выравнивание");
            return false;
        } else if(isRedLine != that.isRedLine){
            ErrorInText.setError("Нет красной строки в параграфе");
            ErrorInText.setText(((ParagraphSettings) o).paragraph.getFirst().getTextSpace());
            System.out.println("Ошибка в красной строке");
            return false;
        } else if (paragraph.size() != that.paragraph.size()) {
            System.out.println(paragraph.size());
            for(var p : paragraph){
                System.out.println(p.getTextSpace().toString());
            }
            System.out.println(that.paragraph.size());
            for(var p : that.paragraph){
                System.out.println(p.getTextSpace().toString());
            }
            ErrorInText.setError("Тексты не совпадают");
            ErrorInText.setText(((ParagraphSettings) o).paragraph.getFirst().getTextSpace());
            System.out.println("Ошибка в тексте");
            return false;
        } else {
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
