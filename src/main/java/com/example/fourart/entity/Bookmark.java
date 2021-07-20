package com.example.fourart.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Bookmark {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "posting_id")
    private Long postingId;

    @Column(name = "member_id")
    private Long memberId;
}
