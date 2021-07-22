package com.example.fourart.repository;

import com.example.fourart.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostingRepository extends JpaRepository<Posting, Long> {
    @Modifying
    @Query("update Posting p set p.viewCount = p.viewCount + 1l where p.id = :id")
    void updateView(Long id);

    @Modifying
    @Query("update Posting p set p.title = :title, p.content = :content where p.id = :id")
    void updatePosting(Long id,String title,String content);
}
