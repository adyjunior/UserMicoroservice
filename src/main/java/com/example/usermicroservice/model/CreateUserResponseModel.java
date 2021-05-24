package com.example.usermicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
public class CreateUserResponseModel {

    private String userId;
    private String firstName;
    private String lastName;
    private String email;

}
