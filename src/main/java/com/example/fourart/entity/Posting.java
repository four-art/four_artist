package com.example.fourart.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@DiscriminatorColumn
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DynamicInsert
public class Posting {
    @Id
    @GeneratedValue
    private Long id;


    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member author;

    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private PostingCategory postingCategory;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "view_count")
    @ColumnDefault("0")
    private Long viewCount;

    @Column(name = "create_account_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

}
