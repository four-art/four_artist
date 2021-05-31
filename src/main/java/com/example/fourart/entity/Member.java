package com.example.fourart.entity;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Getter @Setter
@Table
@NoArgsConstructor
public class Member implements Serializable {

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

    @Column(name = "update_date")
    private LocalDateTime updateDate;
    @Builder
    public Member(String nickname, String email, Role role, String profile_img,SocialLoginType socialLoginType, LocalDateTime createDate, LocalDateTime updateDate){
        this.nickname = nickname;
        this.email = email;
        this.role = role;
        this.instagram = null;
        this.profile_img = profile_img;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
