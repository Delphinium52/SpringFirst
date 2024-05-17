package com.example.demo.controller;


import com.example.demo.dto.CalRequestDto;
import com.example.demo.dto.CalResponseDto;
import com.example.demo.entity.Calendar;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @GetMapping("/calendar/{calendarid}")
    @ResponseBody
    public List<CalResponseDto> getCalendar(@PathVariable int calendarid){
            List<CalResponseDto> calendars = calendarlist.values().stream().map(CalResponseDto::new).toList();
            Optional<CalResponseDto> option = calendars.stream().filter(x -> x.getCalendarid() == calendarid).findFirst();
            return option.isPresent() ? Collections.singletonList(option.get()) : Collections.emptyList();
        }



}
