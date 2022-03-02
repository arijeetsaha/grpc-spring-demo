package com.arijeet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.arijeet.resources.Student;
import com.arijeet.service.StudentService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/internal/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    private Mono<Student> getStudentDetails(@PathVariable("id") String studentId) {
        return Mono.justOrEmpty(studentService.getStudentDetails(studentId));
    }
}
