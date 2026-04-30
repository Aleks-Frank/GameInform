package com.example.serverStudent.controller;

import com.example.serverStudent.entity.Tasks;
import com.example.serverStudent.service.interfaces.TasksServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final TasksServiceInter tasksService;

    @Autowired
    public TasksController(TasksServiceInter tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("/{id}")
    public Tasks getTasksByID(@PathVariable("id") Long id){
        return tasksService.findById(id).orElse(null);
    }

}
