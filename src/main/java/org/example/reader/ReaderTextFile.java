package org.example.reader;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.example.entity.ParagraphSettings;
import org.example.entity.RunSettings;
import org.example.entity.TextLine;
import org.example.entity.UnderlineSettings;
import org.example.entity.enumList.Alignment;
import org.example.reader.SpaceWorker.SpaceWorker;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;


public class ReaderTextFile {

    private File docxFile;

    public ReaderTextFile() {
    }

    public ReaderTextFile(File docxFile) {
        this.docxFile = docxFile;
    }

    public List<ParagraphSettings> parseDocument(){
        List<ParagraphSettings> paragraph = new ArrayList<>();

        try(FileInputStream fis = new FileInputStream(docxFile);
            XWPFDocument document = new XWPFDocument(fis)) {
            for(int i = 0; i < document.getParagraphs().size(); i++){
                paragraph.add(readParagraph(document.getParagraphs().get(i)));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return paragraph;
    }

    private ParagraphSettings readParagraph(XWPFParagraph paragraph){
        ParagraphSettings paragraphSettings = new ParagraphSettings();
        List<TextLine> runList = new ArrayList<>();

        for(int i = 0; i < paragraph.getRuns().size(); i++){
            TextLine run = readRuns(paragraph.getRuns().get(i));
            runList.add(run);
        }

        List<TextLine> mergedRuns = mergeRunsWithSameSettings(runList);

        List<TextLine> clearRuns = SpaceWorker.normalizeSpace(mergedRuns);

        paragraphSettings.setParagraph(clearRuns);
        paragraphSettings.setRedLine(paragraph.getIndentationFirstLine() > 0);
        paragraphSettings.setAlignment(readAlignment(paragraph));
        return paragraphSettings;
    }

//    private Alignment readAlignment(Element element){
//        String defaultAlign = "left";
//        NodeList paragraphProperties = element.getElementsByTagName("w:pPr");
//        if(paragraphProperties.getLength() > 0) {
//            Element pPr = (Element) paragraphProperties.item(0);
//            NodeList justification = pPr.getElementsByTagName("w:jc");
//            if(justification.getLength() > 0){
//                Element jc = (Element) justification.item(0);
//                defaultAlign = jc.getAttribute("w:val");
//            }
//        }
//        return ReaderAlignment.readAlignment(defaultAlign);
//    }

    private TextLine readRuns(XWPFRun run){
        return new TextLine(readText(run), readSettings(run));
    }

    private String readText(XWPFRun run){
        return run.text();
    }

    private RunSettings readSettings(XWPFRun run){
        RunSettings settings = new RunSettings();

        settings.setNameFont(run.getFontName());
        settings.setSizeFont(run.getFontSize());
        settings.setUnderline();


        return settings;
    }

    private boolean isEmptyParagraph(ParagraphSettings paragraph) {
        if (paragraph == null) return true;

        List<TextLine> textLines = paragraph.getParagraph();
        if (textLines == null || textLines.isEmpty()) return true;

        for (TextLine line : textLines) {
            if (line != null && line.getText() != null && !line.getText().trim().isEmpty()) {
                return false;
            }
        }

        return true;
    }

    private boolean isEmptyIgnoringTrailingSpaces(ParagraphSettings paragraph) {
        if (paragraph == null) return true;

        List<TextLine> textLines = paragraph.getParagraph();
        if (textLines == null || textLines.isEmpty()) return true;

        for (TextLine line : textLines) {
            if (line != null && line.getText() != null) {
                // Удаляем пробелы в конце строки
                String textWithoutTrailingSpaces = line.getText().replaceAll("\\s+$", "");
                if (!textWithoutTrailingSpaces.isEmpty()) {
                    return false; // Есть значимый текст
                }
            }
        }

        return true; // Только пробелы в конце или пустая строка
    }

    private List<TextLine> mergeRunsWithSameSettings(List<TextLine> runs) {
        if (runs == null || runs.isEmpty()) return runs;

        List<TextLine> merged = new ArrayList<>();
        TextLine current = runs.get(0);

        for (int i = 1; i < runs.size(); i++) {
            TextLine next = runs.get(i);

            // Проверяем, совпадают ли настройки
            if (areSettingsEqual(current.getSettings(), next.getSettings())) {
                // Объединяем текст
                String mergedText = current.getText() + next.getText();
                current = new TextLine(mergedText, current.getSettings());
            } else {
                // Добавляем текущий в результат и начинаем новый
                merged.add(current);
                current = next;
            }
        }
        merged.add(current);

        return merged;
    }

    private boolean areSettingsEqual(RunSettings s1, RunSettings s2) {
        if (s1 == null && s2 == null) return true;
        if (s1 == null || s2 == null) return false;

        return s1.getSizeFont() == s2.getSizeFont() &&
                Objects.equals(s1.getNameFont(), s2.getNameFont()) &&
                Objects.equals(s1.getBold(), s2.getBold()) &&
                Objects.equals(s1.getItalic(), s2.getItalic()) &&
                Objects.equals(s1.getColorText(), s2.getColorText()) &&
                Objects.equals(s1.getUnderline(), s2.getUnderline()) &&
                Objects.equals(s1.getStrikethrough(), s2.getStrikethrough());
    }

}
