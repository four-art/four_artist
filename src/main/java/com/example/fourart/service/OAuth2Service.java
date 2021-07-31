package com.example.fourart.service;

import com.example.fourart.entity.Member;
import com.example.fourart.entity.SocialLoginType;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class OAuth2Service {
    public Member getUserEmailAndProfileImg(OAuth2User oAuth2User){
        Member member = new Member();
        try{
            LinkedHashMap attribute = oAuth2User.getAttribute("kakao_account");
            LinkedHashMap profile = (LinkedHashMap) attribute.get("profile");
            member.setNickname(profile.get("nickname").toString());
            if(attribute.get("has_email").equals(true)){
                member.setEmail(attribute.get("email").toString());
            }
            if(profile.get("is_default_image").equals(true)){
                member.setProfile_img("profile_image_url");
            }
            else{
                member.setProfile_img(profile.get("profile_image_url").toString());
            }
            member.setSocialLoginType(SocialLoginType.KAKAO);
        }catch(NullPointerException ex){
            Map attribute = oAuth2User.getAttributes();
            member.setNickname(attribute.get("name").toString());
            member.setEmail(attribute.get("email").toString());
            try{
                member.setProfile_img(attribute.get("picture").toString());
                member.setSocialLoginType(SocialLoginType.GOOGLE);
            }catch(NullPointerException nullPointerException){
                member.setProfile_img(attribute.get("profile_image").toString());
                member.setSocialLoginType(SocialLoginType.NAVER);
            }
        }
        return member;
    }
}
