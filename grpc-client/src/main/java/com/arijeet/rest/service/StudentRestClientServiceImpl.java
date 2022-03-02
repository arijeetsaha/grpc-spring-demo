package com.arijeet.rest.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.arijeet.grpc.client.resource.AddressResource;
import com.arijeet.grpc.client.resource.StudentResource;
import com.arijeet.resources.Address;
import com.arijeet.resources.Student;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class StudentRestClientServiceImpl implements StudentRestClientService{

    @Override
    public Mono<StudentResource> getStudentDetails(String studentId) {
        return WebClient.create().get()
                .uri("http://localhost:8082/internal/students/{id}", studentId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Student.class)
                .map(student -> mapper(student));
    }

    private StudentResource mapper( Student student) {
        Address address = student.getAddress();
        AddressResource addressResource = new AddressResource(address.getAddressLine1(), address.getAddressLine2(),
                address.getCity(), address.getCountry(), address.getPinCode());
        StudentResource studentResource = new StudentResource(student.getId(), student.getName(), addressResource);
        return studentResource;
    }
}
