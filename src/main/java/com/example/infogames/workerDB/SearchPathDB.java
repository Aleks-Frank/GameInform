package com.example.infogames.workerDB;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SearchPathDB {
    private static String pathGlob;

    public static String SearchPath(){
        Path path = Paths.get("src/main/resources/db/tasks.db");
        String resource = path.toAbsolutePath().toString();
        return "jdbc:sqlite:" + resource;
    }
}
