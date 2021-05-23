package com.example.fourart.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    ARTIST("ROLE_ARTIST","인증회원"),
    ADMIN("ROLE_ADMIN","관리자"),
    GUEST("ROLE_GUEST","비인증회원");
    
    private final String key;
    private final String title;

}
