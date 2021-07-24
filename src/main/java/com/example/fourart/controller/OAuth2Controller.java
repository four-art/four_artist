package com.example.fourart.controller;

import com.example.fourart.entity.InstaOAuth2Token;
import com.example.fourart.entity.Member;
import com.example.fourart.entity.Role;
import com.example.fourart.entity.SocialLoginType;
import com.example.fourart.service.InstaConnectService;
import com.example.fourart.service.MemberService;
import com.example.fourart.service.OAuth2Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.springframework.http.HttpHeaders.USER_AGENT;

@Controller
@Slf4j
@RequiredArgsConstructor
public class OAuth2Controller {

    private final InstaConnectService instaConnectService;
    private final MemberService memberService;
    private final OAuth2Service oAuth2Service;


    @GetMapping({"/loginSuccess","/success"})
    public Member loginSuccess(@AuthenticationPrincipal OAuth2User oAuth2User){
        //여기서 그냥 MemberService 호출해서 Repository 연결하면 될
        /**
         * profile 어트리뷰트 가져오는 것으로 카카오,(구글,네이버 구분)
         * 구글, 네이버 프로필 사진 저장해놓은 key 명칭이 다름
         */
        Member member = new Member();
        Member temp = oAuth2Service.getUserEmailAndProfileImg(oAuth2User);
        member.setNickname(temp.getNickname());
        member.setEmail(temp.getEmail());
        member.setProfile_img(temp.getProfile_img());
        member.setRole(Role.GUEST);
        member.setCreateDate(LocalDateTime.now());
        member.setUpdateDate(LocalDateTime.now());
        member.setInstagram(null);
        //member.setMemberHashTag(new ArrayList<>());
        member.setInterestingSubject(new ArrayList<>());
        memberService.join(member);
        return member;
    }


    @GetMapping("/loginFail")
    public String loginFail(){
        return "Landing_page";
    }

    @GetMapping("/logout")
    public void logout(){

    }

}
