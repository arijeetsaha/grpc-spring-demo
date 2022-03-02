package com.arijeet.rest.service;

import com.arijeet.grpc.client.resource.StudentResource;

import reactor.core.publisher.Mono;

public interface StudentRestClientService {

    Mono<StudentResource> getStudentDetails(String studentId);
}
