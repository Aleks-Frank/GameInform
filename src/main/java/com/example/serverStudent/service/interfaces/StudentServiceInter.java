package com.example.serverStudent.service.interfaces;

import com.example.serverStudent.entity.Student;

import java.util.Optional;

public interface StudentServiceInter {
    Student save(Student student);
    void delete(Long id);
    Optional<Student> findById(Long id);
    Student findByLogin(String login);
    Student updateInfo(Student student);
}
