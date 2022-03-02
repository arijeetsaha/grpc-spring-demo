package com.arijeet.resources;

import java.io.Serializable;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address implements Serializable {

    private static final long serialVersionUID=1l;

    String addressLine1;
    String addressLine2;
    String city;
    Integer pinCode;
    String country;

}
