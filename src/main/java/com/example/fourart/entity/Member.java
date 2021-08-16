package com.example.fourart.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Getter @Setter
public class Member{

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name="nickname")
    private String nickname;

    @Column(name = "email",unique = true,nullable = false)
    private String email;

    @Column(name = "grade")
    private Role role;

    @Column(name = "instagram",nullable = true)
    private String instagram;

    @Column(name = "profile_img")
    private String profile_img;

    @Column(name = "social_login_type")
    private SocialLoginType socialLoginType;

//    @OneToMany(mappedBy = "member")
//    @Enumerated(EnumType.ORDINAL)
//    private List<MemberHashTag> memberHashTag = new ArrayList<>();

    @ElementCollection(targetClass = InterestingSubject.class)
    @Column(name = "interest", nullable = true)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "person_interest")
    private Collection<InterestingSubject> interestingSubject;

    @Column(name = "introduce",columnDefinition = "TEXT")
    private String introduce;

    @Column(name = "create_account_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

}
