package com.example.fourart.service;


import com.example.fourart.entity.Posting;
import com.example.fourart.repository.PostingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostingService{

    private final PostingRepository postingRepository;


    /**
     *  TODO: 글 검색 기능 구현
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
    @Transactional
    public void updatePosting(Long id, String title, String content) {
        postingRepository.updatePosting(id,title,content);
    }
    @Transactional
    public void deletePost(Long id) {
        postingRepository.deleteById(id);
    }
    @Transactional
    public void viewCountUp(Long id){ postingRepository.updateView(id);}
}
