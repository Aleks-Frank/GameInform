package com.example.serverStudent.service.classes;

import com.example.serverStudent.entity.Tasks;
import com.example.serverStudent.repository.TasksRepository;
import com.example.serverStudent.service.interfaces.TasksServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TasksService implements TasksServiceInter {

    private TasksRepository tasksRepository;

    @Autowired
    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    @Override
    public void save(Tasks tasks) {
        tasksRepository.save(tasks);
    }

    @Override
    public void deleteById(Long id) {
        tasksRepository.deleteById(id);
    }

    @Override
    public Optional<Tasks> findById(Long id) {
        return tasksRepository.findById(id);
    }
}
