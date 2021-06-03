package com.example.fourart.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@RequiredArgsConstructor
public enum InterestingSubject {
    HELLO,
    JOB,
    ETC
}
