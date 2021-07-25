package com.example.fourart.repository;

import com.example.fourart.entity.WantedPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WantedPostingRepository extends JpaRepository<WantedPosting, Long> {
}
