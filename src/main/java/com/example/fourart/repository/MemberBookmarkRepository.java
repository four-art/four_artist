package com.example.fourart.repository;

import com.example.fourart.entity.MemberBookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MemberBookmarkRepository extends JpaRepository<MemberBookmark, Long> {
    @Query("select markedMemberId from MemberBookmark where memberId = : id")
    Set<MemberBookmark> findAllByMemberId(Long id);
}
