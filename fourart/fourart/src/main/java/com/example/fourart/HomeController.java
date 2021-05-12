package com.example.fourart;

import com.example.fourart.entity.Member;
import com.example.fourart.service.KakaoService;
import com.example.fourart.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.aspectj.apache.bcel.classfile.annotation.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.parser.Parser;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private KakaoService kakao;

    @Autowired
    private MemberService memberService;

    @GetMapping("home")
    public String home(Model model){
        model.addAttribute("data","hello!!");
        return "home";
    }
    httpConnection connection = httpConnection.getInstance();

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String kakao(){
        StringBuffer loginUrl = new StringBuffer();
        loginUrl.append("https://kauth.kakao.com/oauth/authorize?client_id=");
        loginUrl.append("be7ef71e584d254b94a84c6812e7844b");
        loginUrl.append("&redirect_uri=");
        loginUrl.append("http://localhost:8080/kakao_login"); //카카오 앱에 등록한 redirect URL
        loginUrl.append("&response_type=code");
        String uri = loginUrl.toString();

        System.out.println("goto>>>>>>>>"+uri);
        return "redirect:"+loginUrl.toString();
    }
    @RequestMapping(value="/kakao_login")
    @GetMapping("success")
    public String kakaoLogin(@RequestParam("code") String code, HttpSession session){
        String access_Token = kakao.kakao_token(code);
        System.out.println("access_Token = " + access_Token);

        HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
        System.out.println("login Controller : " + userInfo);
        if (userInfo.get("email") != null) {
            session.setAttribute("userId", userInfo.get("email"));
            session.setAttribute("nickname",userInfo.get("nickname"));
            session.setAttribute("access_Token", access_Token);
        }
        String email = userInfo.get("email").toString();
        String nickname = userInfo.get("nickname").toString();

        Member member = new Member(email, nickname);

        memberService.join(member);
        return "success";
    }
    @RequestMapping(value="/logout")
    public String access(HttpSession session) throws IOException {

        String access_token = (String)session.getAttribute("access_token");
        Map<String, String> map = new HashMap<String, String>();
        map.put("Authorization", "Bearer "+ access_token);

        String result = connection.HttpPostConnection("https://kapi.kakao.com/v1/user/logout", map).toString();
        System.out.println(result);

        return "redirect:/";
    }
}
