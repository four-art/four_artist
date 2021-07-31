package com.example.fourart.repository;

import com.example.fourart.entity.MemberBookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberBookmarkRepository extends JpaRepository<MemberBookmark, Long> {
}
