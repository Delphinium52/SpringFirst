package com.example.demo.controller;


import com.example.demo.dto.CalRequestDto;
import com.example.demo.dto.CalResponseDto;
import com.example.demo.entity.Calendar;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSOutput;

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

    @GetMapping("/calendar/calendars")
    public List<CalResponseDto> getCalendars(){
        List<CalResponseDto> calendars = calendarlist.values().stream().map(CalResponseDto::new).toList();
        return calendars;
    }
    @PutMapping("/calendar/{calendarid}/title/{title}/content/{content}/name/{name}")
    public String updateCalendar(@PathVariable long calendarid, @PathVariable String title,@PathVariable String content,@PathVariable String name){
        if(calendarlist.containsKey(calendarid)){
            Calendar calendar = calendarlist.get(calendarid);
            calendar.update(title, content, name);
            return "변경완료";
        }else{
            throw new IllegalArgumentException("Calendar not found");
        }
    }

    @DeleteMapping("/calendar/{calendarid}")
    public long deleteCalendar(@PathVariable Long calendarid){
        if(calendarlist.containsKey(calendarid)){
            calendarlist.remove(calendarid);
            return calendarid;
        }else {
            throw new IllegalArgumentException("calendarid not found");
        }
    }
}
