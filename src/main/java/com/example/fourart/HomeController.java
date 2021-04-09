package com.example.fourart;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    @GetMapping("home")
    public String home(Model model){
        model.addAttribute("data","hello!!");
        return "ya";
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



        System.out.println(">>>>>>>>"+uri);
        return "redirect:"+loginUrl.toString();
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
