package com.example.fourart.repository;

import com.example.fourart.entity.HashTag;
import com.example.fourart.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Set;
import java.util.List;
@Repository
public interface PostingRepository extends JpaRepository<Posting, Long> {
    @Modifying
    @Query("update Posting p set p.viewCount = p.viewCount + 1l where p.id = :id")
    void updateView(Long id);

    @Modifying
    @Query("update Posting p set p.title = :title, p.content = :content where p.id = :id")
    void updatePosting(Long id,String title,String content);

    @Modifying
    @Query("select id from Posting where content like %:toFind%")
    List<Long> searchPostings(String toFind);

    @Modifying
    @Query("select p.id from Posting p inner join WantedPosting wp where wp.hashtag = :hashTag")
    Set<Long> searchByPostingHashTag(HashTag hashTag);

    @Modifying
    @Query("select p.id from Posting p where p.author.nickname like %:toFind%")
    Set<Long> searchAuthor(String toFind);
}
