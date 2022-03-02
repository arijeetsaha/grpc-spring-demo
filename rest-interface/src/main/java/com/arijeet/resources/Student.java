package com.arijeet.resources;

import java.io.Serializable;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student implements Serializable {

    private static final long serialVersionUID=1l;
    String id;
    String name;
    Address address;
    StudentType studentType;
}
