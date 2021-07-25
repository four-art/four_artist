package com.example.fourart.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class WantedPostingHashTag {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posting_id")
    private WantedPosting wantedPosting;

    @Column(name = "hashtag", nullable = true)
    @Enumerated(EnumType.STRING)
    private HashTag wantedPostingHashTag;
}
