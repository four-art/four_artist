package com.example.fourart.repository;

import com.example.fourart.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostingRepository extends JpaRepository<Posting, Long> {
    @Modifying
    @Query("update Posting p set p.viewCount = p.viewCount + 1l where p.id = :id")
    void updateView(Long id);
}
