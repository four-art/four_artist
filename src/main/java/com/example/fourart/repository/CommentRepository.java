package com.example.fourart.repository;

import com.example.fourart.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CommentRepository extends JpaRepository<Comment,Long>{

    @Modifying
    @Query("update Comment set content = :content where id = :id")
    void updateComment(Long id, String content);

    @Modifying
    @Query("select id from Comment where targetPostingId = :postingId and commentGroup = :commentId")
    Optional<Comment> findCommentByIds(Long postingId, Long commentId);

    @Modifying
    @Query("select id from Comment where targetPostingId = :id")
    List<Comment> findCommentsByTargetPostingId(Long id);

    @Modifying
    @Query("delete from Comment where targetPostingId = :postingId and commentGroup = :commentId")
    void deleteByIds(Long postingId, Long commentId);
}
