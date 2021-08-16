package com.example.fourart.form;

import com.example.fourart.entity.MemberHashTag;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import java.util.List;
@Getter @Setter
public class MemberForm {
    @NotEmpty(message = "인스타그램 계정 등록")
    private String instagram;

    @NotEmpty(message = "닉네임")
    private String nickname;

    @Null(message = "#프로필해시태그 추가하기")
    private List<MemberHashTag> hashTagList;

    @Null(message = "간략소개 (최대 100자)")
    private String introduce;
}
