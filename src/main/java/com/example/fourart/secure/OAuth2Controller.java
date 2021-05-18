package com.example.fourart.secure;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OAuth2Controller {

    @GetMapping({"","/"})
    public String getAuthorizationMessage(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping({"/loginSuccess","/success"})
    public String loginSuccess(){
        return "loginSuccess";
    }

    @GetMapping("/loginFail")
    public String loginFail(){
        return "loginFail";
    }
}
