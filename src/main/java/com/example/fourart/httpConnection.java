package com.example.fourart;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class httpConnection {
    public static final String ENCODING = "UTF-8";
    private httpConnection(){};
    private static class httpConnection_Singleton{
        private static final httpConnection instance = new httpConnection();
    }

    public static httpConnection getInstance(){
        return httpConnection_Singleton.instance;
    }

    //GET
    public StringBuffer HttpGetConnection(String API_URL) throws IOException{
        StringBuffer response = new StringBuffer();
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");

        return responseHttp(connection);
    }
    //POST
    public StringBuffer HttpPostConnection(String API_URL, Map<String, String> params) throws IOException{
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        if(params.get("Authorization") != null){
            connection.setRequestProperty("Authorization",params.get("Authorization"));
            params.remove("Authorization");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
        StringBuilder sb = new StringBuilder();

        int amp = 0;
        for(String key : params.keySet()){
            if(amp >= 1) sb.append("&");
            amp+=1;
            sb.append(key+params.get(key));
        }
        System.out.println("parameter : " + sb.toString());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        return responseHttp(connection);
    }

    //서버로 요청 보내기
    public StringBuffer responseHttp(HttpURLConnection connection) throws IOException{
        StringBuffer response = new StringBuffer();

        int responseCode = connection.getResponseCode();
        BufferedReader br;
        if(responseCode== 200){
            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        }else{
            br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        }

        String inputLine;
        while ((inputLine = br.readLine()) != null){
            response.append(inputLine);
        }
        br.close();

        return response;
    }

    public String URLencoder(String contents) throws UnsupportedEncodingException{
        return URLEncoder.encode(URLEncoder.encode(contents,ENCODING),"MS949");
    }

}
