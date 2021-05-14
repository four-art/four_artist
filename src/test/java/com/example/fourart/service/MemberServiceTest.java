package com.example.fourart.service;

import com.example.fourart.entity.AgeRange;
import com.example.fourart.entity.Gender;
import com.example.fourart.entity.Member;
import com.example.fourart.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
//Given
        Member member = new Member();
        member.setEmail("dsafsda@gmail.com");

        System.out.println("here");
//When
        Long saveId;
        System.out.println("here");
        saveId = memberService.join(member);
        /* Then */
        assertEquals(member, memberRepository.find(saveId));
    }

    @Test
    public void 중복_회원_예외() throws Exception {
//Given
        Member member1 = new Member(); member1.setEmail("kim@naver.com");
        Member member2 = new Member(); member2.setEmail("kim@naver.com");
//When
        memberService.join(member1); memberService.join(member2); //예외가 발생해야 한다.
//Then
        fail("예외가 발생해야 한다.");
    }
}