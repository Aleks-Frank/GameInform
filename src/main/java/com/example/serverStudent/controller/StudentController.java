package com.example.serverStudent.controller;

import com.example.serverStudent.dto.LoginDTO;
import com.example.serverStudent.entity.Student;
import com.example.serverStudent.service.classes.StudentService;
import com.example.serverStudent.util.IndicationsNotCreatedException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService service;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public StudentController(StudentService service, PasswordEncoder passwordEncoder) {
        this.service = service;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/registration")
    public Student registration(@RequestBody @Valid Student student,
                                                   BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error : errors){
                errorMsg.append(error.getField())
                        .append(" --- ").append(error.getDefaultMessage())
                        .append(";");
            }
            throw new IndicationsNotCreatedException(errorMsg.toString());
        }
        Student existing = service.findByLogin(student.getLogin());
        if(existing != null){
            return null;
        } else {
            String encodedPassword = passwordEncoder.encode(student.getPassword());
            student.setPassword(encodedPassword);
            return service.save(student);
        }
    }

    @PostMapping("/login")
    public Student loginStudent(@RequestBody @Valid LoginDTO loginDTO,
                                BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error : errors){
                errorMsg.append(error.getField())
                        .append(" --- ").append(error.getDefaultMessage())
                        .append(";");
            }
            throw new IndicationsNotCreatedException(errorMsg.toString());
        }

        Student existing = service.findByLogin(loginDTO.getLogin());
        if(existing != null && passwordEncoder.matches(loginDTO.getPassword(), existing.getPassword())){
            return existing;
        } else {
            return null;
        }
    }

    @PostMapping("/update")
    public Student updateStudent(@RequestBody @Valid Student student,
                                BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error : errors){
                errorMsg.append(error.getField())
                        .append(" --- ").append(error.getDefaultMessage())
                        .append(";");
            }
            throw new IndicationsNotCreatedException(errorMsg.toString());
        }
        String encodedPassword = passwordEncoder.encode(student.getPassword());
        student.setPassword(encodedPassword);
        return service.updateInfo(student);
    }

}
