package com.example.infogames.docxFileWorker;

import com.example.infogames.globalEntity.GlobalStudentUser;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateAndOpenFileWord {
    private static String nameUser;
    private static String lastNameUser;
    private static String fileName;
    private static File gameDataFolder;

    static {
        initGameDataFolder();
    }

    private static void initGameDataFolder() {
        if (isRunningFromJar()) {
            File jarDir = getJarDirectory();
            gameDataFolder = new File(jarDir, "GameFiles");
        } else {
            String projectDir = System.getProperty("user.dir");
            gameDataFolder = new File(projectDir, "src/main/resources/File");
        }

        if (!gameDataFolder.exists()) {
            if (gameDataFolder.mkdirs()) {
                System.out.println("Создана папка: " + gameDataFolder.getAbsolutePath());
            }
        }
    }

    private static boolean isRunningFromJar() {
        String className = CreateAndOpenFileWord.class.getName().replace('.', '/');
        String classJar = CreateAndOpenFileWord.class.getResource("/" + className + ".class").toString();
        return classJar.startsWith("jar:");
    }

    private static File getJarDirectory() {
        try {
            String path = CreateAndOpenFileWord.class.getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI()
                    .getPath();
            File jarFile = new File(path);
            return jarFile.getParentFile();
        } catch (Exception e) {
            e.printStackTrace();
            return new File(".");
        }
    }

    public static void workerFileWord() {
        if (GlobalStudentUser.globalStudent == null) {
            System.err.println("Пользователь не авторизован");
            return;
        }

        nameUser = GlobalStudentUser.globalStudent.getFirstName();
        lastNameUser = GlobalStudentUser.globalStudent.getLastName();

        fileName = "File_" + nameUser + "_" + lastNameUser + ".docx";

        File file = new File(gameDataFolder, fileName);

        if (file.exists()) {
            openWordFile(file);
        } else {
            createNewWordFile(file);
        }
    }

    private static void createNewWordFile(File file) {
        XWPFDocument document = new XWPFDocument();

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            document.write(fileOutputStream);
            System.out.println("Файл создан: " + file.getAbsolutePath());
            openWordFile(file);
        } catch (IOException e) {
            System.err.println("Ошибка сохранения файла: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                document.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void openWordFile(File file) {
        try {
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                createNewWordFile(file);
            }
        } catch (IOException e) {
            System.err.println("Ошибка открытия файла: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
