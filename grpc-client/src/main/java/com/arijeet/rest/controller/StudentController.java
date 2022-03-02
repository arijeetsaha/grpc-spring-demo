package com.arijeet.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arijeet.grpc.client.resource.StudentResource;
import com.arijeet.grpc.client.service.StudentGrpcClientService;
import com.arijeet.rest.service.StudentRestClientService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentGrpcClientService studentGrpcClientService;

    @Autowired
    private StudentRestClientService studentRestClientService;

    @GetMapping("/grpc/{id}")
    public Mono<StudentResource> getGrpcStudentById(@PathVariable("id") String studentId) {
        return Mono.justOrEmpty(studentGrpcClientService.getStudentDetails(studentId));
    }

    @GetMapping("/rest/{id}")
    public Mono<StudentResource> getRestStudentById(@PathVariable("id") String studentId) {
        return studentRestClientService.getStudentDetails(studentId);
    }
}
