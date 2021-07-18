package com.example.fourart.entity;

import lombok.Data;

@Data
public class InstaOAuth2Token {
    private String access_token;
    private Long user_id;

}
