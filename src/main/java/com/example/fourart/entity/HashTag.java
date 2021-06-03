package com.example.fourart.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HashTag {
    @Id @GeneratedValue
    @Column(name = "HASHTAG_ID")
    private Long id;

    @Column(name = "hash_tag")
    private String tagName;
}
