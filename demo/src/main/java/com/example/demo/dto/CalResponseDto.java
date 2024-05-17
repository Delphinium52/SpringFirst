package com.example.demo.dto;

import com.sparta.springproject.entity.Calendar;
import com.sparta.springproject.entity.User;
import lombok.Getter;

import java.util.Date;

@Getter
public class CalResponseDto {
    private long calendarid;
    private String title;
    private String content;
    private Date date;
    private long userid;
    User user = new User();

    public CalResponseDto(Calendar calendar) {
        this.calendarid = calendar.getCalendarid();
        this.title = calendar.getTitle();
        this.content = calendar.getContent();
        this.date = calendar.getDate();
        this.userid = calendar.getUserid();
        this.user = calendar.getUser();
    }
}
