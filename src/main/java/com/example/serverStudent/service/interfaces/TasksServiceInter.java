package com.example.serverStudent.service.interfaces;

import com.example.serverStudent.entity.Tasks;

import java.util.Optional;

public interface TasksServiceInter {
    void save(Tasks tasks);
    void deleteById(Long id);
    Optional<Tasks> findById(Long id);
}
