package com.example.fourart.form;

import com.example.fourart.entity.HashTag;

import javax.validation.constraints.NotEmpty;
import java.util.List;
public class WantedPostingForm extends PostingForm{

    @NotEmpty(message = "게시글 해시태그 선택")
    private List<HashTag> wantedPostingHashTag;
}
