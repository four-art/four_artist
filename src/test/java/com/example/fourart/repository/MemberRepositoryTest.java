package com.example.fourart.repository;

import com.example.fourart.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;


    @Test
    @Transactional
    @Rollback(false)
    public void testMember(){
        Member member = new Member();
        member.setEmail("sdasfasf@adsa.com");
        Long id = memberRepository.save(member);
        System.out.println("\n\n\n\n\n"+id+"\n\n\n\n");
    }


    @Test
    void find() {
    }

    @Test
    void testSave() {
    }

    @Test
    void testFind() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findByEmail() {
    }
}