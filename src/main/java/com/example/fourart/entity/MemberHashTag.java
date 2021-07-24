package com.example.fourart.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
public class MemberHashTag {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "hashtag", nullable = true)
    @Enumerated(EnumType.STRING)
    private HashTag memberHashTag;

}
