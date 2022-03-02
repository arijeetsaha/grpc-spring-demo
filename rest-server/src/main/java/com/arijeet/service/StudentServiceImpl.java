package com.arijeet.service;

import org.springframework.stereotype.Service;

import com.arijeet.resources.Address;
import com.arijeet.resources.Student;
import com.arijeet.resources.StudentType;

@Service
public class StudentServiceImpl implements StudentService{
    @Override
    public Student getStudentDetails(String studentId) {
        Address address = new Address();
        address.setAddressLine1("A-82 Sector 2C");
        address.setAddressLine2("Bidhannagar");
        address.setCity("Durgapur");
        address.setCountry("India");
        address.setPinCode(713212);

        Student student = new Student();
        student.setId(studentId);
        student.setAddress(address);
        student.setStudentType(StudentType.STUDENT_TYPE_DISTANCE);
        student.setName("Arijeet Saha");

        return student;
    }
}
