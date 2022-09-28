package com.rentCar.userservice.Resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientResource {
    private Long id;
    private String names;
    private String lastNames;
    private String email;
    private String password;
    private Long contactNumber;
    private Long dni;
    private String image;
    private Double rating;
}
