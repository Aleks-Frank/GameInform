module com.example.infogames {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires org.apache.poi.ooxml;
    requires ormlite.jdbc;
    requires java.sql;
    requires tools.jackson.databind;
    requires spring.web;
    requires spring.beans;
    requires com.fasterxml.jackson.annotation;

    // Открываем все пакеты с entity для Jackson
    opens com.example.infogames.entity to
            javafx.fxml,
            com.fasterxml.jackson.databind,
            tools.jackson.databind,  // Добавляем tools.jackson.databind
            ormlite.jdbc,
            ormlite.core;

    // Открываем весь модуль для рефлексии Jackson
    opens com.example.infogames to
            javafx.fxml,
            com.fasterxml.jackson.databind,
            tools.jackson.databind,
            spring.core;

    exports com.example.infogames.entity to
            ormlite.jdbc,
            ormlite.core,
            com.fasterxml.jackson.databind,
            tools.jackson.databind;

    exports com.example.infogames;
    exports com.example.infogames.controllers;

    opens com.example.infogames.controllers to
            javafx.fxml,
            com.fasterxml.jackson.databind,
            tools.jackson.databind;
}