package com.example.serverStudent.service.classes;

import com.example.serverStudent.entity.Student;
import com.example.serverStudent.repository.StudentRepository;
import com.example.serverStudent.service.interfaces.StudentServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements StudentServiceInter {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student findByLogin(String login) {
        return studentRepository.findByLogin(login);
    }

    @Override
    public Student updateInfo(Student student) {
        Student existing = studentRepository.findById(student.getId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existing.setName(student.getName());
        existing.setSurname(student.getSurname());
        existing.setRole(student.getRole());
        existing.setClassStudent(student.getClassStudent());
        existing.setSchool(student.getSchool());
        existing.setLogin(student.getLogin());
        existing.setPassword(student.getPassword());
        existing.setStars(student.getStars());

        return studentRepository.save(existing);
    }
}
