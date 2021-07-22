package com.example.fourart.service;

import com.example.fourart.entity.Comment;
import com.example.fourart.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public void saveComment(Comment comment){commentRepository.save(comment);}
    @Transactional
    public void updateComment(Long id,String content){
        commentRepository.updatePosting(id,content);
    }
    @Transactional
    public void deleteComment(Long id){commentRepository.deleteById(id);}

}
