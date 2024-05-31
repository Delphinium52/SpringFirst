package com.example.demo.service;

import com.example.demo.dto.CalRequestDto;
import com.example.demo.dto.CalResponseDto;
import com.example.demo.entity.Calendar;
import com.example.demo.repository.CalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CalService {
    private final CalRepository calRepository;
    public CalService(CalRepository calRepository) {
        this.calRepository = calRepository;
    }
    public CalResponseDto createCalendar(CalRequestDto requestDto) {
        // requestDto - > entity
        Calendar calendar = new Calendar(requestDto);
        Calendar savedCalendar = calRepository.save(calendar);

        CalResponseDto calResponseDto = new CalResponseDto(calendar);
        return calResponseDto;

    }

    public List<CalResponseDto> getCalendar() {
       return calRepository.findAll().stream().map(CalResponseDto::new).toList();
    }

    @Transactional
    public Long updateCalendar(Long id, CalRequestDto requestDto) {
        Calendar calendar = findCalendar(id);
        if (calendar != null) {
            calendar.update(requestDto);
            return id;
        } else {
            throw new IllegalArgumentException("id not found");
        }
    }

    public long deleteCalendar(Long id) {
        Calendar calendar = findCalendar(id);
        if(calendar != null){
            calRepository.delete(calendar);
            return id;
        }else {
            throw new IllegalArgumentException("id not found");
        }

    }

    private Calendar findCalendar(Long id){
    return calRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Calendar not found")
      );
    }
}
