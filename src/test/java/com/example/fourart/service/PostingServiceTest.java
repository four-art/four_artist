package com.example.fourart.service;

import com.example.fourart.entity.HashTag;
import com.example.fourart.entity.Posting;
import com.example.fourart.entity.WantedPosting;
import com.example.fourart.repository.PostingRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static com.example.fourart.entity.HashTag.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PostingServiceTest {
    @Autowired
    PostingService postingService;


    @Test
    void savePosting() {
        WantedPosting wantedPosting = new WantedPosting();
        Collection<HashTag> hashTags = new ArrayList<>();
        hashTags.add(PERFORMANCE);
        hashTags.add(FLUTE);
        wantedPosting.setTitle("test");
        wantedPosting.setWantedPostingHashtag(hashTags);
        wantedPosting.setContent("adasdasdasddfsafsfsdafasdf");
        wantedPosting.setViewCount(0l);
        postingService.savePosting(wantedPosting);
        viewCountUp();
    }



    @Test
    void findPostings() {
        List<Posting> postings = new ArrayList<>();
        postings = postingService.findPostings();
        System.out.println(postings.toString());
    }


    @Test
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
}