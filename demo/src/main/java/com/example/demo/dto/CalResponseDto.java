package com.example.demo.dto;

import com.example.demo.entity.Calendar;

import com.example.demo.entity.User;
import lombok.Getter;

import java.util.Date;

@Getter
public class CalResponseDto {
    private long calendarid;
    private String title;
    private String content;
    private String name;
    private String pw;
    private Date date = new Date();

    public CalResponseDto(Calendar calendar) {
        this.calendarid = calendar.getCalendarid();
        this.title = calendar.getTitle();
        this.content = calendar.getContent();
        this.date = calendar.getDate();
        this.name = calendar.getName();
        this.pw = calendar.getPw();
    }

}
