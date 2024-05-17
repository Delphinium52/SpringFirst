package com.example.demo.dto;

import com.sparta.springproject.entity.User;
import lombok.Getter;

import java.util.Date;

@Getter
public class CalRequestDto {
    private long calendarid;
    private String title;
    private String content;
    private Date date;
    private long userid;
    User user = new User();
}
