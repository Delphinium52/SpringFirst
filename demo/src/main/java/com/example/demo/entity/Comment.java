package com.example.demo.entity;

import com.example.demo.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "comment")
public class Comment extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "content", length = 1000)
    private String content;
    @Column(name = "userid")
    private String userid;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "calendar_id")
    private Calendar calendar;

    public Comment(CommentRequestDto commentRequestDto,Calendar calendar) {
        this.content = commentRequestDto.getContent();
        this.userid = commentRequestDto.getUserId();
        this.calendar = calendar;
    }

    public void update(CommentRequestDto commentRequestDto) {
        this.content = commentRequestDto.getContent();
        this.userid = commentRequestDto.getUserId();

    }
}
