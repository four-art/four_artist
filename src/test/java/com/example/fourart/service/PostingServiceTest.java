package com.example.fourart.service;

import com.example.fourart.entity.HashTag;
import com.example.fourart.entity.Posting;
import com.example.fourart.entity.WantedPosting;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static com.example.fourart.entity.HashTag.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class PostingServiceTest {
    @Autowired
    PostingService postingService;

    @Test
    void savePosting() {
        WantedPosting wantedPosting = new WantedPosting();
        Set<HashTag> hashTags = new HashSet<>();
        hashTags.add(PERFORMANCE);
        hashTags.add(FLUTE);
        wantedPosting.setTitle("test");
        wantedPosting.setWantedPostingHashtag(hashTags);
        wantedPosting.setContent("adasdasdasddfsafsfsdafasdf");
        wantedPosting.setViewCount(0l);
        postingService.savePosting(wantedPosting);
        Posting posting = new WantedPosting();
        posting.setTitle("test");
        posting.setContent("adasdasdasddfsafsfsdafasdf");
        posting.setViewCount(0l);
        postingService.savePosting(posting);
        viewCountUp();
        searchPostings();
        searchByPostingHashTag();
    }



    @Test
    void findPostings() {
        List<Posting> postings = new ArrayList<>();
        postings = postingService.findPostings();
        System.out.println(postings.toString());
    }


    //@Test
    void deletePost() {
        Posting posting = new WantedPosting();
        posting.setTitle("test");
        posting.setContent("adasdasdasddfsafsfsdafasdf");
        posting.setViewCount(0l);
        postingService.savePosting(posting);
        postingService.deletePost((long) 1);
    }

    @Test
    void viewCountUp() {
        Posting posting = (Posting)postingService.findOne(1l);

        postingService.viewCountUp(posting.getId());
        postingService.viewCountUp(posting.getId());
        postingService.viewCountUp(posting.getId());
        postingService.viewCountUp(posting.getId());
        postingService.viewCountUp(posting.getId());

    }

    //@Test
    void searchPostings() {

        System.out.println("111111111");
        List<Long> s = postingService.searchPostings("a");

        System.out.print(s.toString()+"\t");

        System.out.println("111111111");
    }

    void searchByPostingHashTag() {
        System.out.println("111111111");
        Set<Long> s = postingService.searchByPostingHashTag(PERFORMANCE);

        System.out.print(s.toString()+"\t");

        System.out.println("111111111");
    }
}