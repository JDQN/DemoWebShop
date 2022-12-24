package com.tricentis.demowebshop.model;


import lombok.Data;

@Data
public class UserRegistre {
    private String FirstName;
    private String LastName;
    private String email;
    private String password;
}
