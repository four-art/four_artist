package com.example.fourart.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

@Entity
@Getter @Setter
@DiscriminatorColumn
@Inheritance(strategy = InheritanceType.JOINED)
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

    @ElementCollection(targetClass = HashTag.class)
    @Column(name = "hashtag", nullable = true)
    @Enumerated(EnumType.STRING)
    private Set<HashTag> wantedPostingHashtag;

    @Column(name = "create_account_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

}
