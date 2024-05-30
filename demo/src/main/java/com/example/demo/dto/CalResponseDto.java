package com.example.demo.dto;

import com.example.demo.entity.Calendar;

import lombok.Getter;
import java.time.LocalDateTime;


@Getter
public class CalResponseDto {
    private Long id;
    private String title;
    private String content;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CalResponseDto(Calendar calendar) {
        this.id = calendar.getId();
        this.title = calendar.getTitle();
        this.content = calendar.getContent();
        this.name = calendar.getName();
        this.createdAt = calendar.getCreatedAt();
        this.modifiedAt = calendar.getModifiedAt();
    }

}
