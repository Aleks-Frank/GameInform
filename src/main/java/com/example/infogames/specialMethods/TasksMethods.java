package com.example.infogames.specialMethods;

import com.example.infogames.globalEntity.GlobalTask;
import javafx.scene.control.Label;

import java.text.MessageFormat;

public class TasksMethods {
    public static void setTasksInfo(Label numberTasks, Label nameTasks, Label countCoins){
        numberTasks.setText(MessageFormat.format("Задание №{0}", GlobalTask.globalTasks.getNumberTasks()));
        nameTasks.setText(GlobalTask.globalTasks.getNameTasks());
        countCoins.setText(String.valueOf(GlobalTask.globalTasks.getCountStars()));
    }
}
