package com.example.demo.dto;

import com.example.demo.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private Long id;
    private String content;
    private String userid;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
    private Long calendarId;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.userid = comment.getUserid();
        this.createAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
        this.calendarId = comment.getCalendar().getId();
    }
}
