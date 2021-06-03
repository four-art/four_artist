package com.example.fourart.entity;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;
import net.minidev.json.JSONArray;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
public class Member implements Serializable {

    @Id @GeneratedValue
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

    //@OneToMany(mappedBy = "HASHTAG_ID")
    //private List<HashTag> hash_tag = new ArrayList<>();

    @ElementCollection(targetClass = InterestingSubject.class)
    @Column(name = "interest", nullable = true)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "person_interest")
    private Collection<InterestingSubject> interestingSubject;

    @Column(name = "create_account_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

}
