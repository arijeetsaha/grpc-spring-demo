package com.arijeet.grpc.server.service;

import com.arijeet.grpc.proto.Student;
import com.arijeet.grpc.proto.StudentSearchRequest;
import com.arijeet.grpc.proto.StudentServiceGrpc;
import com.arijeet.grpc.proto.StudentType;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class StudentServerService extends StudentServiceGrpc.StudentServiceImplBase {

    @Override
    public void getStudentDetails(StudentSearchRequest request, StreamObserver<Student> responseObserver) {
        Student student = Student.newBuilder().setStudentId(request.getStudentId())
                .setAddress(com.arijeet.grpc.proto.Address.newBuilder()
                        .setAddressLine1("A-508 Embassy Golf Club")
                        .setAddressLine2("Marathahalli")
                        .setCity("Bengaluru")
                        .setCountry("India")
                        .setPinCode(560200)
                        .build())
                .setStudentType(StudentType.STUDENT_TYPE_DISTANCE)
                .setName("Rohan Gupta")
                .build();
        responseObserver.onNext(student);
        responseObserver.onCompleted();
    }
}
