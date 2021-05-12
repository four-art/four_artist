package com.example.fourart.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    private Long id;

    @Column(name="nickname")
    private String nickname;

    @Column(name = "email")
    private String email;

    @Column(name = "instagram")
    @Nullable
    private String instagram;

    public Member(String email, String nickname) {
        this.nickname = nickname;
        this.email = email;
    }

    /**
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "age_range")
    private AgeRange ageRange;

    @Lob
    @Column(name = "info",nullable = true)
    private String info;
    **/
}
