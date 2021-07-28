package com.example.fourart;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class httpsConnection {
    public static final String ENCODING = "UTF-8";
    private httpsConnection(){};
    private static class httpsConnection_Singleton{
        private static final httpsConnection_Singleton instance = new httpsConnection_Singleton();
    }

    public static httpsConnection_Singleton getInstance(){
        return httpsConnection_Singleton.instance;
    }

    //GET
    public StringBuffer HttpGetConnection(String API_URL) throws IOException{
        StringBuffer response = new StringBuffer();
        URL url = new URL(API_URL);
        HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
        connection.setRequestMethod("GET");

        return responseHttps(connection);
    }
    //POST
    public StringBuffer HttpPostConnection(String API_URL, Map<String, String> params) throws IOException{
        URL url = new URL(API_URL);
        HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
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
        return responseHttps(connection);
    }

    //서버로 요청 보내기
    public StringBuffer responseHttps(HttpsURLConnection connection) throws IOException{
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
