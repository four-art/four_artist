package com.example.fourart.service;

import com.example.fourart.entity.HashTag;
import com.example.fourart.entity.Member;
import com.example.fourart.entity.MemberHashTag;
import com.example.fourart.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final EntityManager em;
    @Transactional
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }


    private void validateDuplicateMember(Member member){
        List<Member> findMembers = memberRepository.findAllByEmail(member.getEmail());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
    public Member findMembers(String email){
        return memberRepository.findByEmail(email);
    }
    public void addHashTag(Long id,HashTag hashTag){
        Member member = memberRepository.getOne(id);
        MemberHashTag memberHashTag = new MemberHashTag();
        memberHashTag.setMember(member);
        memberHashTag.setMemberHashTag(hashTag);
        em.persist(memberHashTag);
    }
    public void addHashTagList(Long id, List<HashTag> hashTagList){
        for(HashTag h : hashTagList){
            addHashTag(id,h);
        }
        em.flush();
    }
}
