package com.example.infogames.textFileWorker.entity;

import java.util.Objects;

public class RunSettings {
    private String nameFont = "Aptos";
    private double sizeFont = 12;
    private Boolean isBold = false;
    private Boolean isItalic = false;
    private String colorText = "black";
    private String underline = null;
    private String highlighting = null;
    private Boolean strikethrough = false;

    public RunSettings() {
    }

    public RunSettings(String nameFont, double sizeFont, Boolean isBold, Boolean isItalic, String colorText, String underline, String highlighting, Boolean stikethrough) {
        this.nameFont = nameFont;
        this.sizeFont = sizeFont;
        this.isBold = isBold;
        this.isItalic = isItalic;
        this.colorText = colorText;
        this.underline = underline;
        this.highlighting = highlighting;
        this.strikethrough = stikethrough;
    }

    public String getNameFont() {
        return nameFont;
    }

    public void setNameFont(String nameFont) {
        this.nameFont = nameFont;
    }

    public double getSizeFont() {
        return sizeFont;
    }

    public void setSizeFont(double sizeFont) {
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

    public String getUnderline() {
        return underline;
    }

    public void setUnderline(String underline) {
        this.underline = underline;
    }

    public String getHighlighting() {
        return highlighting;
    }

    public void setHighlighting(String highlighting) {
        this.highlighting = highlighting;
    }

    public Boolean getStrikethrough() {
        return strikethrough;
    }

    public void setStrikethrough(Boolean strikethrough) {
        this.strikethrough = strikethrough;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RunSettings settings = (RunSettings) o;
        if(!(sizeFont == settings.sizeFont)){
            ErrorInText.setError("Размер должен быть: " + settings.sizeFont);
            return false;
        } else if (!Objects.equals(nameFont, settings.nameFont)){
            ErrorInText.setError("Шрифт должен быть: " + settings.nameFont);
            System.out.println("Ошибка в шрифте");
            return false;
        } else if (!Objects.equals(isBold, settings.isBold)){
            ErrorInText.setError("Жирный должен быть: " + settings.isBold);
            System.out.println("Ошибка в шрифте");
            return false;
        } else if (!Objects.equals(isItalic, settings.isItalic)){
            ErrorInText.setError("Курсив должен быть: " + settings.isItalic);
            System.out.println("Ошибка в шрифте");
            return false;
        } else if (!Objects.equals(colorText, settings.colorText)) {
            ErrorInText.setError("Цвет должен быть: " + settings.colorText);
            System.out.println("Ошибка в шрифте");
            return false;
        } else if (!Objects.equals(underline, settings.underline)) {
            ErrorInText.setError("Подчеркивание должно быть: " + settings.underline);
            System.out.println("Ошибка в шрифте");
            return false;
        } else if (!Objects.equals(highlighting, settings.highlighting)) {
            ErrorInText.setError("Выдиление должно быть: " + settings.highlighting);
            System.out.println("Ошибка в шрифте");
            return false;
        } else if (!Objects.equals(strikethrough, settings.strikethrough)){
            ErrorInText.setError("Зачеркивание должно быть: " + settings.highlighting);
            System.out.println("Ошибка в шрифте");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameFont, sizeFont, isBold, isItalic, colorText, underline, highlighting, strikethrough);
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
                ", strikethrough='" + highlighting + '\'' +
                '}';
    }
}
