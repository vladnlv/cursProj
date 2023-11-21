package com.example.appp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;

@AllArgsConstructor
@Data
public class UserDto {

    private String name;

    private String email;

    private String password;

}
