package com.arijeet.grpc.client.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResource {

    String addressLine1;
    String addressLine2;
    String city;
    String country;
    Integer pinCode;

}
