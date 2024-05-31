package com.example.demo.controller;


import com.example.demo.dto.CalRequestDto;
import com.example.demo.dto.CalResponseDto;
import com.example.demo.service.CalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CalendarController {
    private final CalService calService;

    public CalendarController(CalService calService){this.calService = calService;}
    @PostMapping("/calendars")
    public CalResponseDto createCalendar(@RequestBody CalRequestDto requestDto) {
       return  calService.createCalendar(requestDto);
    }

    @GetMapping("/calendars")
    @ResponseBody
    public List<CalResponseDto> getCalendar(){return calService.getCalendar();}

    @PutMapping("/calendar/{calendarid}")
    public Long updateCalendar(@PathVariable Long calendarid, @RequestBody CalRequestDto requestDto) {
        return calService.updateCalendar(calendarid, requestDto);
    }


    @DeleteMapping("/calendar/{calendarid}")
    public long deleteCalendar(@PathVariable Long calendarid){
        return calService.deleteCalendar(calendarid);
    }
}
