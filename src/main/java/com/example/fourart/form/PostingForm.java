package com.example.fourart.form;

import com.example.fourart.entity.PostingCategory;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class PostingForm {
    @NotEmpty(message = "게시글의 제목을 입력해주세요.")
    private String title;

    @NotEmpty(message = "게시글 주제 선택")
    private PostingCategory postingCategory;

    @NotEmpty(message = "4rtist의 다양한 아티스트 회원과 주제별로 소통해보세요.")
    private String content;
}
