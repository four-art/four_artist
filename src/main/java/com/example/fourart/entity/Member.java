package com.example.fourart.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Date;

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
    private String instagram;

    @Column(name = "profile_img")
    private String profile_img;

    @Column(name = "create_account_date")
    private Date crateDate;



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
