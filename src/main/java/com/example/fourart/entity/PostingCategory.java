package com.example.fourart.entity;

import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public enum PostingCategory {
    HELLO("hello"),//가입인사
    TOGETHER("together"),//함께해요
    FIND("find"),//구해요
    ARTFORUM("artforum"),//아트포럼
    PROMOTION("promotion"),//활동홍보
    QUESTION("question"),//질문이요
    RECOMMEND("recommend"),//추천해요
    ETC("etc");//잡담

    private String category;

    PostingCategory(String category) {
        this.category = category;
    }

}
