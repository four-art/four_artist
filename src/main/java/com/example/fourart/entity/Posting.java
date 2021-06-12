package com.example.fourart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Posting {
    @Id
    @GeneratedValue
    private Long id;
}
