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

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final EntityManager em;
    @Transactional
    public Long join(Member member){
        //validate에서 에러 던지나 확인
        try {
            if (validateDuplicateMember(member))
                memberRepository.save(member);
            else{
                member = memberRepository.findByEmail(member.getEmail());
            }
        }catch (IllegalStateException e){
            e.printStackTrace();
        }
        return member.getId();
    }


    private boolean validateDuplicateMember(Member member){
        List<Member> findMembers = memberRepository.findAllByEmail(member.getEmail());
        if(!findMembers.isEmpty()){
            Member findMember = findMembers.get(0);
            if(findMember.getSocialLoginType() != member.getSocialLoginType())
                throw new IllegalStateException("이미 가입된 회원입니다.");
            else{
                return false;
            }
        }
        return true;
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
