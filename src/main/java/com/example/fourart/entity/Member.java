package com.example.fourart.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    private Long id;

    @Column(name="nickname")
    private String nickname;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "grade")
    private Role role;

    @Column(name = "instagram",nullable = true)
    private String instagram;

    @Column(name = "profile_img")
    private String profile_img;

    @Column(name = "create_account_date")
    private LocalDateTime createDate;

    public String toString(){
        return nickname + "," + email + "," + profile_img;
    }
}
