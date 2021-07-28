package com.example.fourart.repository;

import com.example.fourart.entity.PostingBookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends JpaRepository<PostingBookmark, Long> {
}
