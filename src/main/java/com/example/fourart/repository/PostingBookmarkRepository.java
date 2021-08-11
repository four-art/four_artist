package com.example.fourart.repository;

import com.example.fourart.entity.PostingBookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PostingBookmarkRepository extends JpaRepository<PostingBookmark, Long> {
    @Query("select postingId from PostingBookmark where memberId = : id")
    Set<PostingBookmark> findAllByMemberId(Long id);
}
