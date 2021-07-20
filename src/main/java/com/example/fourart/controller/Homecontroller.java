package com.example.fourart.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class Homecontroller {

    @RequestMapping({"/","/home"})
    public String home(){
        log.info("home controller");
        return "home";
    }
}
