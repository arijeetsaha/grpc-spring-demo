package com.arijeet.grpc.client.service;

import org.springframework.stereotype.Service;

import com.arijeet.grpc.client.resource.AddressResource;
import com.arijeet.grpc.client.resource.StudentResource;
import com.arijeet.grpc.proto.Address;
import com.arijeet.grpc.proto.Student;
import com.arijeet.grpc.proto.StudentSearchRequest;
import com.arijeet.grpc.proto.StudentServiceGrpc;

import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;

@Slf4j
@Service
public class StudentGrpcClientServiceImpl implements StudentGrpcClientService{

    @GrpcClient("studentService")
    private StudentServiceGrpc.StudentServiceBlockingStub studentServiceBlockingStub;

    public StudentResource getStudentDetails(String studentId) {
        Student student = studentServiceBlockingStub.getStudentDetails(StudentSearchRequest.newBuilder()
                .setStudentId(studentId)
                .build());
        log.info("Size of the PROTOBUF message size: {}", student.toByteArray().length);
        Address address = student.getAddress();
        AddressResource addressResource = new AddressResource(address.getAddressLine1(), address.getAddressLine2(),
                address.getCity(), address.getCountry(), address.getPinCode());
        StudentResource studentResource = new StudentResource(student.getStudentId(), student.getName(), addressResource);
        return studentResource;
    }
}
