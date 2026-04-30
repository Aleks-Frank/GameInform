package com.example.serverStudent.security;

import com.example.serverStudent.entity.Student;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class StudentDetails implements UserDetails {

    private final Student student;

    public StudentDetails(Student student) {
        this.student = student;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return student.getPassword();
    }

    @Override
    public String getUsername() {
        return student.getLogin();
    }
}
