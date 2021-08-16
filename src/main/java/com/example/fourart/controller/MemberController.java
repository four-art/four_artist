package com.example.fourart.controller;

import com.example.fourart.entity.Member;
import com.example.fourart.form.MemberForm;
import com.example.fourart.repository.MemberRepository;
import com.example.fourart.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MemberController {
    /**
     * TODO :
     *  화면에 뿌려줄 멤버 정보 얻어오기
     *  프로필 편집에서 완료 누르면
     *      화면에서 받아온 정보 업데이트 하기
     *      화면에서 넘어온 정보 저장하기
     *
     */

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @PostMapping(value = "/members/{memberId}/insta")
    public Member link(@Valid MemberForm memberForm, @PathVariable("memberId") BindingResult result){
        if(result.hasErrors()){
            return null;
        }
        Member member = new Member();
        member.setInstagram(memberForm.getInstagram());

        memberRepository.save(member);
        return member;
    }
    @GetMapping(value = "/members/{memberId}/info")
    public Optional<Member> getMemberInfo(@PathVariable("memberId") Long memberId){
        return memberService.findMember(memberId);
    }
}
