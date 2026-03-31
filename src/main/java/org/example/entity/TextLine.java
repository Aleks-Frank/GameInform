package org.example.entity;

import java.util.Objects;

public class TextLine {
    private String text;
    private String textSpace = null;
    private RunSettings settings;

    public TextLine(String text, String textSpace, RunSettings settings) {
        this.text = text;
        this.textSpace = textSpace;
        this.settings = settings;
    }

    public TextLine(String text, RunSettings settings) {
        this.text = text;
        this.settings = settings;
    }

    public String getTextSpace() {
        return textSpace;
    }

    public void setTextSpace(String textSpace) {
        this.textSpace = textSpace;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public RunSettings getSettings() {
        return settings;
    }

    public void setSettings(RunSettings settings) {
        this.settings = settings;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TextLine textLine = (TextLine) o;
        if (!Objects.equals(text, textLine.text)){
            ErrorInText.setError(textSpace);
            ErrorInText.setText(textLine.textSpace);
            return false;
        } else if (!Objects.equals(settings, textLine.settings)) {
            ErrorInText.setText(textLine.textSpace);
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(text);
    }
}
