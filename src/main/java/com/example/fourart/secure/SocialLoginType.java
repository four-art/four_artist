package com.example.fourart.secure;

public enum SocialLoginType {
    GOOGLE("google"),
    FACEBOOK("facebook"),
    KAKAO("kakao"),
    NAVER("naver");

    private final String ROLE_PREFIX = "ROLE_";
    private String name;

    SocialLoginType(String name){this.name = name;}

    public String getRoleType() {return ROLE_PREFIX + name.toUpperCase();}
    public String getValue(){return name;}

    public boolean isEquals(String auth){ return this.getRoleType().equals(auth);}

}
