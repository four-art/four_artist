package com.example.fourart.controller;

import com.example.fourart.entity.Member;
import com.example.fourart.form.MemberForm;
import com.example.fourart.repository.MemberRepository;
import com.example.fourart.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    private final MemberRepository memberRepository;

    @PostMapping(value = "/members/insta")
    public String link(@Valid MemberForm memberForm, BindingResult result){
        if(result.hasErrors()){
            return "/members/createMemberForm";
        }
        Member member = new Member();
        member.setInstagram(memberForm.getInstagram());

        memberRepository.join(member);
        return "redirect:/home";

    }
}
