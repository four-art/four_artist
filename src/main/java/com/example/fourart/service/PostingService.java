package com.example.fourart.service;


import com.example.fourart.entity.*;
import com.example.fourart.repository.PostingRepository;
import com.example.fourart.repository.WantedPostingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostingService{

    private final PostingRepository postingRepository;
    private final WantedPostingRepository wantedPostingRepository;
    private final EntityManager em;
    /**
     *  TODO: 글 검색 기능 구현
     */
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
        postingRepository.updatePosting(id,title,content);
    }
    public void deletePost(Long id) {
        postingRepository.deleteById(id);
    }
    public Long viewCountUp(Long id){
        postingRepository.updateView(id);
        return postingRepository.searchView(id);
    }
    public List<Long> searchPostings(String toFind){
        return postingRepository.searchPostings(toFind);
    }
    public Set<Long>  searchByPostingHashTag(HashTag hashTag){
        return postingRepository.searchByPostingHashTag(hashTag);
    }
    public Set<Long> searchAuthor(String toFind){
        return postingRepository.searchAuthor(toFind);
    }
    public void addHashTag(Long id,HashTag hashTag){
        WantedPosting wantedPosting = wantedPostingRepository.getOne(id);
        WantedPostingHashTag wantedPostingHashTag = new WantedPostingHashTag();
        wantedPostingHashTag.setWantedPosting(wantedPosting);
        wantedPostingHashTag.setWantedPostingHashTag(hashTag);
        em.persist(wantedPostingHashTag);
    }
    public void addHashTagList(Long id, List<HashTag> hashTagList){
        for(HashTag h : hashTagList){
            addHashTag(id,h);
        }
        em.flush();
    }
}
