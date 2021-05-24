package com.example.fourart.controller;

import com.example.fourart.service.SocialLoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Collection;

@Controller
@Slf4j
@RequiredArgsConstructor
public class OAuth2Controller {

    private final SocialLoginService socialLoginService;

    @GetMapping({"","/"})
    public String getAuthorizationMessage(){
        return "index";
    }

    @GetMapping({"/loginSuccess","/success"})
    public String loginSuccess(){
        return "signup";
    }

    @GetMapping("/loginFail")
    public String loginFail(){
        return "loginFail";
    }
}
