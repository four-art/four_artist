package com.example.fourart.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Comment {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "comment_author")
    private String author;

    @Column(name = "target_posting_id")
    private Long targetPostingId;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "reference_group")
    private Long refGroup;

    @Column(name = "comment_group")
    private Long commentGroup;

    @Column(name = "create_account_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;
}
