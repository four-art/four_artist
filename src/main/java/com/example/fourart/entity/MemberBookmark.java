package com.example.fourart.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class MemberBookmark {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "marked_member_id")
    private Long markedMemberId;

    @Column(name = "member_id")
    private Long memberId;
}
