package org.example.entity;

import org.example.entity.enumList.Underline;

import java.util.Objects;

public class UnderlineSettings {
    private Underline nameLine = Underline.UNDERLINE;
    private String colorLine = "black";

    public UnderlineSettings() {
    }

    public UnderlineSettings(Underline nameLine, String colorLine) {
        this.nameLine = nameLine;
        this.colorLine = colorLine;
    }

    public Underline getNameLine() {
        return nameLine;
    }

    public void setNameLine(Underline nameLine) {
        this.nameLine = nameLine;
    }

    public String getColorLine() {
        return colorLine;
    }

    public void setColorLine(String colorLine) {
        this.colorLine = colorLine;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UnderlineSettings that = (UnderlineSettings) o;
        return nameLine == that.nameLine && Objects.equals(colorLine, that.colorLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameLine, colorLine);
    }
}
