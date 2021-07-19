package com.example.fourart.service;

import com.example.fourart.entity.HashTag;
import com.example.fourart.entity.Member;
import com.example.fourart.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

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
    public void addHashTag(Long id,List<HashTag> hashTagList){
        Member member = memberRepository.getOne(id);
        member.setMemberHashTag(hashTagList);
    }
}
