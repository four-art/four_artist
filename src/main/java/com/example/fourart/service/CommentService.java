package com.example.fourart.service;

import com.example.fourart.entity.Comment;
import com.example.fourart.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public Optional<Comment> getComment(Long postingId, Long commentId){ return commentRepository.findCommentByIds(postingId, commentId); }
    @Transactional
    public List<Comment> getComments(Long id) { return commentRepository.findCommentsByTargetPostingId(id); }

    @Transactional
    public void saveComment(Comment comment){commentRepository.save(comment);}
    @Transactional
    public void updateComment(Long id, String content){
        commentRepository.updateComment(id, content);
    }
    @Transactional
    public void deleteComment(Long postingId, Long commentId){commentRepository.deleteByIds(postingId, commentId);}

}
