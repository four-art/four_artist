package com.example.fourart.service;

import com.example.fourart.entity.*;
import com.example.fourart.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;


    @BeforeEach
    void setUp() {
        Member m1 = new Member();

        m1.setNickname("gooder");
        m1.setEmail("shc950217@naver.com");
        m1.setRole(Role.ADMIN);
        m1.setInstagram("bit_cheol");
        m1.setProfile_img(null);
        m1.setSocialLoginType(SocialLoginType.KAKAO);

        m1.setInterestingSubject(null);
        m1.setCreateDate(LocalDateTime.now());
        m1.setUpdateDate(LocalDateTime.now());
        MemberHashTag mh1 = new MemberHashTag();
        mh1.setMemberHashTag(HashTag.ANIME);
        mh1.setMemberHashTag(HashTag.BALLET);
        mh1.setMemberHashTag(HashTag.DOCUMENTARIES);
        mh1.setMember(m1);

        Member m2 = new Member();
        m2.setNickname("gooder");
        m2.setEmail("shc950217@naver.com");
        m2.setRole(Role.ADMIN);
        m2.setInstagram("bit_cheol");
        m2.setProfile_img(null);
        m2.setSocialLoginType(SocialLoginType.KAKAO);
        m2.setInterestingSubject(null);
        m2.setCreateDate(LocalDateTime.now());
        m2.setUpdateDate(LocalDateTime.now());
        MemberHashTag mh2 = new MemberHashTag();
        mh2.setMemberHashTag(HashTag.ANIME);
        mh2.setMemberHashTag(HashTag.BALLET);
        mh2.setMemberHashTag(HashTag.DOCUMENTARIES);
        mh2.setMember(m2);
    }

//    @Test
//    void join() {
//    }
//
//    @Test
//    void findMembers() {
//    }
//
//    @Test
//    void addHashTag() {
//    }
//
//    @Test
//    void addHashTagList() {
//    }
//
//    @Test
//    void memberPostings() {
//    }

    @Test
    void searchByMemberHashTag() {
        System.out.println(memberRepository.searchByMemberHashTag(HashTag.ANIME).toString());

    }
}