package com.arijeet.grpc.client.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResource {

    String name;
    String id;
    AddressResource addressResource;
}
