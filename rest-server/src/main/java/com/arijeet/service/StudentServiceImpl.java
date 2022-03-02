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
        address.setAddressLine1("A-508 Embassy Golf Club");
        address.setAddressLine2("Marathahalli");
        address.setCity("Bengaluru");
        address.setCountry("India");
        address.setPinCode(560200);

        Student student = new Student();
        student.setId(studentId);
        student.setAddress(address);
        student.setStudentType(StudentType.STUDENT_TYPE_DISTANCE);
        student.setName("Rohan Gupta");

        return student;
    }
}
