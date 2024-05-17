package com.example.demo.dto;


import com.example.demo.entity.User;
import lombok.Getter;

import java.util.Date;

@Getter
public class CalRequestDto {
    private long calendarid;
    private String title;
    private String content;
    private String name;
    private String pw;

}
