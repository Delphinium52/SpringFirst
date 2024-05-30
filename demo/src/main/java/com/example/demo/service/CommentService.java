package com.example.demo.service;

import com.example.demo.dto.CalRequestDto;
import com.example.demo.dto.CalResponseDto;
import com.example.demo.dto.CommentRequestDto;
import com.example.demo.dto.CommentResponseDto;
import com.example.demo.entity.Calendar;
import com.example.demo.entity.Comment;
import com.example.demo.repository.CalRepository;
import com.example.demo.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final CalRepository calRepository;
    public CommentService(CommentRepository commentRepository, CalRepository calRepository) {
        this.commentRepository = commentRepository;
        this.calRepository = calRepository;
    }
    public CommentResponseDto createComment(CommentRequestDto requestDto) {
        // requestDto - > entity
        Optional<Calendar> optionalCalendar =  calRepository.findById(requestDto.getCalendarId());
        if (optionalCalendar.isPresent()) {
            Calendar calendar = optionalCalendar.get();
            Comment comment = new Comment(requestDto, calendar);
            commentRepository.save(comment);
            CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
            return commentResponseDto;
        }else{
            return null;
        }
    }

    public List<CommentResponseDto> getComment() {
        return commentRepository.findAll().stream().map(CommentResponseDto::new).toList();
    }

    @Transactional
    public Long updateCalendar(Long id, CommentRequestDto requestDto) {
        Comment comment = findComment(id);
        if (comment != null) {
            comment.update(requestDto);
            return id;
        } else {
            throw new IllegalArgumentException("id not found");
        }
    }

    public long deleteCalendar(Long id) {
        Comment comment = findComment(id);
        if(comment != null){
            commentRepository.delete(comment);
            return id;
        }else {
            throw new IllegalArgumentException("id not found");
        }

    }

    private Comment findComment(Long id){
        return commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("comment not found")
        );
    }
}
