package com.example.fourart.repository;

import com.example.fourart.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long>{

    @Modifying
    @Query("update Posting p set p.content = :content where p.id = :id")
    void updatePosting(Long id,String content);
}
