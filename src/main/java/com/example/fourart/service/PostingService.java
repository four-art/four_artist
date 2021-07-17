package com.example.fourart.service;


import com.example.fourart.entity.Posting;
import com.example.fourart.repository.PostingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostingService{

    private final PostingRepository postingRepository;


    /**
     *  TODO: 글 삭제, 검색 기능 구현 예
     */
    @Transactional
    public void savePosting(Posting posting) {
        postingRepository.save(posting);
    }

    public List<Posting> findPostings() {
        return postingRepository.findAll();
    }

    public Object findOne(Long postingId) {
        return postingRepository.getOne(postingId);
    }

    public void updatePosting(Long id, String title, String content) {
        Posting posting = postingRepository.getOne(id);
        posting.setTitle(title);
        posting.setContent(content);
    }

    public void deletePost(Long id) {
        postingRepository.deleteById(id);
    }
}
