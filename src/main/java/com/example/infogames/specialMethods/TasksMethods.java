package com.example.infogames.specialMethods;

import com.example.infogames.globalEntity.GlobalTask;
import com.example.infogames.textFileWorker.entity.ErrorInText;
import com.example.infogames.textFileWorker.entity.ParagraphSettings;
import com.example.infogames.textFileWorker.entity.RunSettings;
import com.example.infogames.textFileWorker.entity.TextLine;
import com.example.infogames.textFileWorker.jsonWorker.ParseJSON;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

public class TasksMethods {
    public static void setTasksInfo(Label numberTasks, Label nameTasks, Label countCoins){
        numberTasks.setText(MessageFormat.format("Задание №{0}", GlobalTask.globalTasks.getNumberTasks()));
        nameTasks.setText(GlobalTask.globalTasks.getNameTasks());
        countCoins.setText(String.valueOf(GlobalTask.globalTasks.getCountStars()));
    }

    public static void setCountStars(Label countCoins){
        countCoins.setText(String.valueOf(GlobalTask.globalTasks.getCountStars()));
    }

    public static void setDescriptions(Label descriptions){
        descriptions.setText(String.valueOf(GlobalTask.globalTasks.getDescription()));
    }

    public static void setError(Label error, Label textError){
        textError.setText(ErrorInText.getText());
        error.setText(String.valueOf(ErrorInText.getError()));
    }

    private static Node createStyledNode(String text, RunSettings settings) {
        Text textNode = new Text(text + " ");

        if (settings == null) {
            return textNode;
        }

        // Настройки шрифта
        String fontFamily = settings.getNameFont() != null ? settings.getNameFont() : "Aptos";
        int fontSize = (int) (settings.getSizeFont() > 0 ? settings.getSizeFont() : 12);

        FontWeight fontWeight = (settings.getBold() != null && settings.getBold()) ?
                FontWeight.BOLD : FontWeight.NORMAL;

        FontPosture fontPosture = (settings.getItalic() != null && settings.getItalic()) ?
                FontPosture.ITALIC : FontPosture.REGULAR;

        textNode.setFont(Font.font(fontFamily, fontWeight, fontPosture, fontSize));

        // Цвет текста
        if (settings.getColorText() != null && !settings.getColorText().isEmpty()) {
            try {
                textNode.setFill(Color.web(settings.getColorText()));
            } catch (Exception e) {
                textNode.setFill(Color.BLACK);
            }
        }

        // Зачеркивание
        if (settings.getStrikethrough() != null && settings.getStrikethrough()) {
            textNode.setStrikethrough(true);
        }

        // Подчеркивание
        if (!Objects.equals(settings.getUnderline(), "NONE") && !settings.getUnderline().isEmpty()) {
            textNode.setUnderline(true);
        }

        // Выделение (фон)
        if (!Objects.equals(settings.getHighlighting(), "none") && !settings.getHighlighting().isEmpty()) {
            return wrapWithHighlight(textNode, settings.getHighlighting());
        }

        return textNode;
    }

    /**
     * Оборачивает текст в контейнер с фоном (выделение)
     */
    private static Node wrapWithHighlight(Text textNode, String highlightColor) {
        HBox wrapper = new HBox(textNode);
        String formattedColor = formatColor(highlightColor);
        wrapper.setStyle("-fx-background-color: " + formattedColor + "; " +
                "-fx-padding: 2px 4px 2px 4px; " +
                "-fx-background-radius: 3px;");
        return wrapper;
    }

    /**
     * Форматирует цвет для CSS
     */
    private static String formatColor(String color) {
        if (color == null || color.isEmpty()) {
            return "yellow";
        }
        color = color.trim();
        switch (color.toLowerCase()) {
            case "yellow": return "yellow";
            case "red": return "red";
            case "green": return "green";
            case "blue": return "blue";
            case "cyan": return "cyan";
            case "magenta": return "magenta";
            case "orange": return "orange";
            case "pink": return "pink";
            case "gray": return "gray";
            case "black": return "black";
            case "white": return "white";
            default:
                if (color.startsWith("#")) return color;
                if (color.matches("[0-9A-Fa-f]{6}")) return "#" + color;
                return "yellow";
        }
    }

    /**
     * Добавляет один параграф в TextFlow
     */
    private static void addParagraphToTextFlow(TextFlow textFlow, ParagraphSettings paragraph) {
        // Создаем HBox для выравнивания всего параграфа
        HBox paragraphContainer = new HBox();
        paragraphContainer.setFillHeight(true);
        paragraphContainer.setMaxWidth(Double.MAX_VALUE); // Растягиваем на всю ширину

        // Создаем VBox для строк параграфа
        VBox linesContainer = new VBox();
        linesContainer.setSpacing(0);
        linesContainer.setMaxWidth(Double.MAX_VALUE); // Растягиваем на всю ширину

        boolean isFirstLine = true;

        for (TextLine textLine : paragraph.getParagraph()) {
            String text = textLine.getTextSpace();
            RunSettings settings = textLine.getSettings();

            if (text != null && !text.isEmpty()) {
                // Для красной строки добавляем отступ
                if (isFirstLine && Boolean.TRUE.equals(paragraph.getRedLine())) {
                    text = "    " + text;
                    isFirstLine = false;
                }

                Node textNode = createStyledNode(text, settings);
                linesContainer.getChildren().add(textNode);
            }
        }

        paragraphContainer.getChildren().add(linesContainer);

        // Устанавливаем выравнивание
        applyAlignment(paragraphContainer, linesContainer, paragraph.getAlignment());

        textFlow.getChildren().add(paragraphContainer);
    }

    /**
     * Применяет выравнивание к параграфу
     */
    private static void applyAlignment(HBox container, VBox linesContainer, String alignment) {
        if (alignment == null) return;

        // Для HBox.setHgrow нужно, чтобы дочерний элемент мог растягиваться
        HBox.setHgrow(linesContainer, Priority.ALWAYS);

        switch (alignment) {
            case "CENTER":
                container.setAlignment(Pos.CENTER);
                linesContainer.setMaxWidth(Region.USE_COMPUTED_SIZE);
                break;
            case "RIGHT":
                container.setAlignment(Pos.CENTER_RIGHT);
                linesContainer.setMaxWidth(Region.USE_COMPUTED_SIZE);
                break;
            case "LEFT":
                container.setAlignment(Pos.CENTER_LEFT);
                linesContainer.setMaxWidth(Region.USE_COMPUTED_SIZE);
                break;
            case "WIDTH":
                // Для выравнивания по ширине нужно растянуть текст
                container.setAlignment(Pos.CENTER);
                linesContainer.setMaxWidth(Double.MAX_VALUE);
                // Устанавливаем выравнивание текста в каждом Text узле
                setTextAlignmentInContainer(linesContainer, TextAlignment.JUSTIFY);
                break;
            default:
                container.setAlignment(Pos.CENTER_LEFT);
                linesContainer.setMaxWidth(Region.USE_COMPUTED_SIZE);
                break;
        }
    }

    /**
     * Устанавливает выравнивание текста для всех узлов в контейнере
     */
    private static void setTextAlignmentInContainer(VBox container, TextAlignment alignment) {
        for (Node node : container.getChildren()) {
            if (node instanceof HBox) {
                // Для обертки с выделением
                for (Node innerNode : ((HBox) node).getChildren()) {
                    if (innerNode instanceof Text) {
                        ((Text) innerNode).setTextAlignment(alignment);
                    }
                }
            } else if (node instanceof Text) {
                ((Text) node).setTextAlignment(alignment);
            }
        }
    }

    /**
     * Основной метод для отображения параграфов
     */
    public static void displayParagraphsInTextFlow(TextFlow textFlow) {
        List<ParagraphSettings> paragraphs = GlobalTask.paragraph;

        if (paragraphs == null || paragraphs.isEmpty()) {
            textFlow.getChildren().clear();
            textFlow.getChildren().add(new Text("Нет данных"));
            return;
        }

        textFlow.getChildren().clear();
        textFlow.setLineSpacing(0);

        // ВАЖНО: Устанавливаем ширину TextFlow для корректного переноса
        if (textFlow.getParent() != null) {
            textFlow.prefWidthProperty().bind(
                    ((Region) textFlow.getParent()).widthProperty().subtract(20)
            );
        }

        for (int i = 0; i < paragraphs.size(); i++) {
            addParagraphToTextFlow(textFlow, paragraphs.get(i));
            // Добавляем пустую строку между параграфами, но не после последнего
            if (i < paragraphs.size() - 1) {
                textFlow.getChildren().add(new Text("\n"));
            }
        }
    }

}
