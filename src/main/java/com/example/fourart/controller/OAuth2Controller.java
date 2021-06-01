package com.example.fourart.controller;

import com.example.fourart.entity.Member;
import com.example.fourart.entity.Role;
import com.example.fourart.service.MemberService;
import com.example.fourart.service.SocialLoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@Slf4j
@RequiredArgsConstructor
public class OAuth2Controller {

    private final SocialLoginService socialLoginService;
    private final MemberService memberService;
    @GetMapping({"","/"})
    public String getAuthorizationMessage(){
        return "index";
    }

    @GetMapping({"/loginSuccess","/success"})
    public String loginSuccess(@AuthenticationPrincipal OAuth2User oAuth2User){
        log.info("Social Login Info");
        //여기서 그냥 MemberService 호출해서 Repository 연결하면 될

        log.info(oAuth2User.getAttributes().toString());
        Member member = new Member();
        try{

            LinkedHashMap attribute = oAuth2User.getAttribute("kakao_account");
            LinkedHashMap profile = (LinkedHashMap) attribute.get("profile");
            member.setNickname(profile.get("nickname").toString());
            if(attribute.get("has_email").equals(true)){
                member.setEmail(attribute.get("email").toString());
            }
            if(profile.get("is_default_image").equals(true)){
                member.setProfile_img("");
            }
            else{
                member.setProfile_img(profile.get("profile_image_url").toString());
            }
            log.info(profile.get("nickname").toString());
        }catch(NullPointerException ex){
            log.info("kakao 로그인 이외의 것들 구현.");

        }
        member.setRole(Role.GUEST);
        member.setCreateDate(LocalDateTime.now());
        member.setUpdateDate(LocalDateTime.now());
        member.setInstagram("");
        memberService.join(member);
        return "signup";
    }

    @GetMapping("/loginFail")
    public String loginFail(){
        return "loginFail";
    }
}
