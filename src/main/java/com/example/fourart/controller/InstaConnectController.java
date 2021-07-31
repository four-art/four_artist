package com.example.fourart.controller;

import com.example.fourart.entity.InstaOAuth2Token;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import static org.springframework.http.HttpHeaders.USER_AGENT;

@Controller
@Slf4j
@RequiredArgsConstructor
public class InstaConnectController {


    @Value("${custom.oauth2.instagram.client-id}") String instaClientId;
    @Value("${custom.oauth2.instagram.client-secret}") String instaClientSecret;
    //프론트 단에서 insta인증 요청을 받으면 여기부터 처리.
    @GetMapping("/insta_request")
    public String instaRequest(){
        String BASE_URL = "https://api.instagram.com/oauth/authorize?";
        String clientId=instaClientId;
        String redirectUri="https://localhost:8443/insta_conn_success";
        String scope = "user_profile";
        String responseType = "code";
        return "redirect:" + BASE_URL + "client_id="+clientId +"&" + "redirect_uri=" + redirectUri +"&scope="+scope +"&response_type="+responseType;
    }
    @GetMapping("/insta_conn_success")
    public String instagramConnect(@RequestParam String code) throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        params.add("client_id",instaClientId);
        params.add("client_secret",instaClientSecret);
        params.add("code",code);
        params.add("grant_type","authorization_code");
        params.add("redirect_uri","https://localhost:8443/insta_conn_success");

        HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(params,headers);

        ResponseEntity response = restTemplate.exchange(
                "https://api.instagram.com/oauth/access_token",
                HttpMethod.POST,
                request,
                String.class
        );
        ObjectMapper objectMapper = new ObjectMapper();

        InstaOAuth2Token oToken = null;

        try {
            oToken = objectMapper.readValue(response.getBody().toString(), InstaOAuth2Token.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:getInstaUsername?user_id="+oToken.getUser_id()+"&access_token="+oToken.getAccess_token();
    }
    //프론트 단에 인스타 아이디 넘겨주기
    @GetMapping("/getInstaUsername")
    public String getInstaUsername(@RequestParam("user_id") Long user_id, @RequestParam("access_token") String accessToken, Model model) throws IOException {

        String sUrl = "https://graph.instagram.com/me?fields=id,username&access_token=";
        URL url = new URL(sUrl+accessToken);
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT); // add request header
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String result = response.toString();
        String[] userInfo = result.split(",");
        String tempUserName = userInfo[1];
        String userName = tempUserName.split(":")[1];
        userName = userName.replace("\"","");
        userName = userName.substring(0,userName.length()-1);

        return userName;
    }
}
