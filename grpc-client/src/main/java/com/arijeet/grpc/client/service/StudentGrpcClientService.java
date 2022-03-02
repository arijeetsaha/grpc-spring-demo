package com.arijeet.grpc.client.service;

import com.arijeet.grpc.client.resource.StudentResource;

public interface StudentGrpcClientService {
    StudentResource getStudentDetails(String studentId);
}
