package com.example.fourart.service;

import com.example.fourart.entity.Member;
import com.example.fourart.repository.MemberRepository;
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

        System.out.println("ser");
        validateDuplicateMember(member);
        System.out.println("member = " + member);
        Long id = memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByEmail(member.getEmail());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 가입된 이메일입니다.");
        }
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Member find(Long memberId){
        return memberRepository.find(memberId);
    }
}
