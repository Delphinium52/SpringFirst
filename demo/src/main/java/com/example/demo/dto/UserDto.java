package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class UserDto {
    private String username;
    private String password;
    private String nickname;
    private LocalDate createAt;
}
