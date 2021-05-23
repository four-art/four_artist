package com.example.fourart.controller;

import com.example.fourart.service.SocialLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class OAuth2Controller {

    private final SocialLoginService socialLoginService;

    @GetMapping({"","/"})
    public String getAuthorizationMessage(){
        return "index";
    }

    @GetMapping({"/loginSuccess","/success"})
    public String loginSuccess(Model model){
        return "signup";
    }

    @GetMapping("/loginFail")
    public String loginFail(){
        return "loginFail";
    }
}
