package com.example.demo.entity;

import com.sparta.springproject.dto.CalRequestDto;
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
    private Date date;
    private long userid;
    User user = new User();

    public Calendar(CalRequestDto requestDto) {
        this.calendarid = requestDto.getCalendarid();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.userid = requestDto.getUserid();
        user = requestDto.getUser();
    }
}
