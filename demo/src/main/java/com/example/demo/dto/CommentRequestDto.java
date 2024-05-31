package com.example.demo.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentRequestDto {
    private String content;
    private String userId;
    private Long calendarId;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

}
