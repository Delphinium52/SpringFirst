package com.example.demo.entity;

import com.example.demo.dto.CalRequestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Calendar {
    private long calendarid;
    private String title;
    private String content;
    private String name;
    private String pw;
    private Date date =new Date();

    public Calendar(CalRequestDto requestDto) {
        this.calendarid = requestDto.getCalendarid();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.name = requestDto.getName();
        this.pw = requestDto.getPw();
    }

}
