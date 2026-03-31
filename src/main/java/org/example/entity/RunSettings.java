package org.example.entity;

import org.example.reader.ReaderAlignment;

import java.util.Objects;

public class RunSettings {
    private String nameFont = "Aptos";
    private int sizeFont = 12;
    private Boolean isBold = false;
    private Boolean isItalic = false;
    private String colorText = "black";
    private UnderlineSettings underline = null;
    private String strikethrough = null;

    public RunSettings() {
    }

    public RunSettings(String nameFont, int sizeFont, Boolean isBold, Boolean isItalic, String colorText, UnderlineSettings underline, String strikethrough) {
        this.nameFont = nameFont;
        this.sizeFont = sizeFont;
        this.isBold = isBold;
        this.isItalic = isItalic;
        this.colorText = colorText;
        this.underline = underline;
        this.strikethrough = strikethrough;
    }

    public String getNameFont() {
        return nameFont;
    }

    public void setNameFont(String nameFont) {
        this.nameFont = nameFont;
    }

    public int getSizeFont() {
        return sizeFont;
    }

    public void setSizeFont(int sizeFont) {
        this.sizeFont = sizeFont;
    }

    public Boolean getBold() {
        return isBold;
    }

    public void setBold(Boolean bold) {
        isBold = bold;
    }

    public Boolean getItalic() {
        return isItalic;
    }

    public void setItalic(Boolean italic) {
        isItalic = italic;
    }

    public String getColorText() {
        return colorText;
    }

    public void setColorText(String colorText) {
        this.colorText = colorText;
    }

    public UnderlineSettings getUnderline() {
        return underline;
    }

    public void setUnderline(UnderlineSettings underline) {
        this.underline = underline;
    }

    public String getStrikethrough() {
        return strikethrough;
    }

    public void setStrikethrough(String strikethrough) {
        this.strikethrough = strikethrough;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RunSettings settings = (RunSettings) o;
        if(!(sizeFont == settings.sizeFont)){
            ErrorInText.setError("Шрифт имеет размер: " + sizeFont
                    + ",а должно быть: " + settings.sizeFont);
            System.out.println("Ошибка в размере");
            return false;
        } else if (!Objects.equals(nameFont, settings.nameFont)){
            ErrorInText.setError("Стоит шрифт: " + nameFont
                    + ",а должно быть: " + settings.nameFont);
            System.out.println("Ошибка в шрифте");
            return false;
        } else if (!Objects.equals(isBold, settings.isBold)){
            ErrorInText.setError("Жирный шрифт стоит: " + isBold
                    + ",а должно быть: " + settings.isBold);
            System.out.println("Ошибка в шрифте");
            return false;
        } else if (!Objects.equals(isItalic, settings.isItalic)){
            ErrorInText.setError("Курсив шрифт стоит: " + isItalic
                    + ",а должно быть: " + settings.isItalic);
            System.out.println("Ошибка в шрифте");
            return false;
        } else if (!Objects.equals(colorText, settings.colorText)) {
            ErrorInText.setError("Стоит цвет: " + colorText
                    + ",а должно быть: " + settings.colorText);
            System.out.println("Ошибка в шрифте");
            return false;
        } else if (!Objects.equals(underline, settings.underline)) {
            ErrorInText.setError("Стоит линия: " + underline.getNameLine()
                    + ",а должно быть: " + settings.underline.getNameLine());
            System.out.println("Ошибка в шрифте");
            return false;
        } else if (!Objects.equals(strikethrough, settings.strikethrough)){
            ErrorInText.setError("Стоит линия: " + strikethrough
                    + ",а должно быть: " + settings.strikethrough);
            System.out.println("Ошибка в шрифте");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameFont, sizeFont, isBold, isItalic, colorText, underline, strikethrough);
    }

    @Override
    public String toString() {
        return "RunSettings{" +
                "nameFont='" + nameFont + '\'' +
                ", sizeFont=" + sizeFont +
                ", isBold=" + isBold +
                ", isItalic=" + isItalic +
                ", colorText='" + colorText + '\'' +
                ", underline=" + underline +
                ", strikethrough='" + strikethrough + '\'' +
                '}';
    }
}
