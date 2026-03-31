package org.example.reader;

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
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
        List<ParagraphSettings> paragraph;

        try(ZipFile zipFile = new ZipFile(docxFile)){
            ZipEntry documentEntry = zipFile.getEntry("word/document.xml");
            if(documentEntry == null){
                throw new IOException("Document not found");
            }
            try(InputStream inputStream = zipFile.getInputStream(documentEntry)){
                paragraph = parseDocumentXml(inputStream);
            } catch (ParserConfigurationException e) {
                throw new RuntimeException(e);
            } catch (SAXException e) {
                throw new RuntimeException(e);
            }
        } catch (ZipException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return paragraph;
    }

    private List<ParagraphSettings> parseDocumentXml(InputStream inputStream) throws ParserConfigurationException, IOException, SAXException {
        List<ParagraphSettings> paragraphsList = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(inputStream);

        NodeList paragraphs = doc.getElementsByTagName("w:p");

        for(int i = 0; i < paragraphs.getLength(); i++){
            Element paragraph = (Element) paragraphs.item(i);
            ParagraphSettings paragraphsToList = readParagraph(paragraph);
            if (!isEmptyParagraph(paragraphsToList) && !isEmptyIgnoringTrailingSpaces(paragraphsToList)) {
                paragraphsList.add(paragraphsToList);
            }
        }

        return paragraphsList;
    }

    private ParagraphSettings readParagraph(Element paragraph){
        ParagraphSettings paragraphSettings = new ParagraphSettings();
        List<TextLine> runList = new ArrayList<>();

        NodeList runs = paragraph.getElementsByTagName("w:r");

        for(int i = 0; i < runs.getLength(); i++){
            Element runElement = (Element) runs.item(i);
            TextLine run = readRuns(runElement);
            runList.add(run);
        }

        // ✅ Объединяем run'ы с одинаковыми настройками
        List<TextLine> mergedRuns = mergeRunsWithSameSettings(runList);

        // ✅ Нормализуем пробелы
        List<TextLine> clearRuns = SpaceWorker.normalizeSpace(mergedRuns);

        paragraphSettings.setParagraph(clearRuns);
        paragraphSettings.setRedLine(readRedLine(paragraph));
        paragraphSettings.setAlignment(readAlignment(paragraph));
        return paragraphSettings;
    }

    private Alignment readAlignment(Element element){
        String defaultAlign = "left";
        NodeList paragraphProperties = element.getElementsByTagName("w:pPr");
        if(paragraphProperties.getLength() > 0) {
            Element pPr = (Element) paragraphProperties.item(0);
            NodeList justification = pPr.getElementsByTagName("w:jc");
            if(justification.getLength() > 0){
                Element jc = (Element) justification.item(0);
                defaultAlign = jc.getAttribute("w:val");
            }
        }
        return ReaderAlignment.readAlignment(defaultAlign);
    }

    private Boolean readRedLine(Element element) {
        NodeList paragraphProps = element.getElementsByTagName("w:pPr");
        if (paragraphProps.getLength() > 0) {
            Element pPr = (Element) paragraphProps.item(0);
            NodeList indNodes = pPr.getElementsByTagName("w:ind");

            if (indNodes.getLength() > 0) {
                Element ind = (Element) indNodes.item(0);
                String firstLine = ind.getAttribute("w:firstLine");
                if (firstLine != null && !firstLine.isEmpty() && !"0".equals(firstLine)) {
                    return true;
                }
            }
        }

        return false;
    }

    private TextLine readRuns(Element element){
        return new TextLine(readText(element), readSettings(element));
    }

    private String readText(Element element){
        StringBuilder text = new StringBuilder();

        NodeList textNode = element.getElementsByTagName("w:t");

        for(int i = 0; i < textNode.getLength(); i++){
            Element textValue = (Element) textNode.item(i);
            String content = textValue.getTextContent();
            if(content != null){
                text.append(content);
            }
        }

        return text.toString();
    }

    private RunSettings readSettings(Element element){
        RunSettings settings = new RunSettings();

        NodeList runProperties = element.getElementsByTagName("w:rPr");

        if(runProperties.getLength() > 0){
            Element rPr = (Element) runProperties.item(0);

            NodeList nameFont = rPr.getElementsByTagName("w:rFonts");
            if(nameFont.getLength() > 0){
                Element font = (Element) nameFont.item(0);
                String name = font.getAttribute("w:ascii");
                if(!name.isEmpty()){
                    settings.setNameFont(name);
                }
            }

            NodeList sizeFont = rPr.getElementsByTagName("w:sz");
            if(sizeFont.getLength() > 0){
                Element size = (Element) sizeFont.item(0);
                String sizeValue = size.getAttribute("w:val");
                if(!sizeValue.isEmpty()){
                    settings.setSizeFont(Integer.parseInt(sizeValue) / 2);
                }
            }

            NodeList bold = rPr.getElementsByTagName("w:b");
            if(bold.getLength() > 0){
                settings.setBold(true);
            }

            NodeList italic = rPr.getElementsByTagName("w:i");
            if(italic.getLength() > 0){
                settings.setItalic(true);
            }

            NodeList colorFont = rPr.getElementsByTagName("w:color");
            if(colorFont.getLength() > 0){
                Element color = (Element) colorFont.item(0);
                String colorValue = color.getAttribute("w:val");
                if(!colorValue.isEmpty()){
                    settings.setColorText(colorValue);
                }
            }

            NodeList underlineFont = rPr.getElementsByTagName("w:u");
            if(underlineFont.getLength() > 0){
                Element underline = (Element) underlineFont.item(0);
                String underlineValue = underline.getAttribute("w:val");
                if(!underlineValue.isEmpty()){
                    UnderlineSettings underlineSettings = new UnderlineSettings();
                    underlineSettings.setNameLine(ReaderUnderline.readUnderline(underlineValue));
                    settings.setUnderline(underlineSettings);
                }
            }

            NodeList strikethroughFont = rPr.getElementsByTagName("w:shd");
            if(strikethroughFont.getLength() > 0){
                Element strikethrough = (Element) strikethroughFont.item(0);
                String strikethroughValue = strikethrough.getAttribute("w:fill");
                if(!strikethroughValue.isEmpty()){
                    settings.setStrikethrough(strikethroughValue);
                }
            }

        }

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
