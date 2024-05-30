package com.example.demo.controller;




import com.example.demo.dto.CommentRequestDto;
import com.example.demo.dto.CommentResponseDto;
import com.example.demo.service.CommentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;
    public CommentController(CommentService commentService){this.commentService = commentService;}
    @PostMapping("/comments")
    public CommentResponseDto createComment(@RequestBody CommentRequestDto requestDto) {
        return  commentService.createComment(requestDto);
    }

    @GetMapping("/comments")
    @ResponseBody
    public List<CommentResponseDto> getCalendar(){return commentService.getComment();}

    @PutMapping("/comment/{commentid}")
    public Long updateCalendar(@PathVariable Long commentid, @RequestBody CommentRequestDto requestDto) {
        return commentService.updateCalendar(commentid, requestDto);
    }


    @DeleteMapping("/comment/{commentid}")
    public long deleteComment(@PathVariable Long commentid){
        return commentService.deleteCalendar(commentid);
    }

}
