package com.example.fourart.service;

import com.example.fourart.entity.Member;
import com.example.fourart.repository.MemberRepository;
import com.example.fourart.repository.SocialLoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member){
        validateDuplicateInsta(member);
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateInsta(Member member){
        List<Member> findMembers = memberRepository.findByInstagram(member.getInstagram());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 가입된 인스타그램 아이디입니다.");
        }
    }
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}
