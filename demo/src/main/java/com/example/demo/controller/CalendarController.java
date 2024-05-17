package com.example.demo.controller;

import com.sparta.springproject.dto.CalRequestDto;
import com.sparta.springproject.dto.CalResponseDto;
import com.sparta.springproject.entity.Calendar;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CalendarController {

    private  final Map<Long, Calendar> calendarlist = new HashMap<>();
    @PostMapping("/calendar")
    @ResponseBody
    public CalResponseDto calendar(@RequestBody CalRequestDto requestDto) {



        // requestDto - > entity
        Calendar calendar = new Calendar(requestDto);

        Long maxId = calendarlist.size() >  0 ? Collections.max(calendarlist.keySet())+1 : 1;
        calendar.setCalendarid(maxId);

        //DB set
        calendarlist.put(calendar.getCalendarid(), calendar);
       //entity ->responseDto
        CalResponseDto responseDto = new CalResponseDto(calendar);
        return responseDto;
    }
}
