package com.example.fourart.controller;

import com.example.fourart.entity.Comment;
import com.example.fourart.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping(value="/comments/{postingId}")
    public List<Comment> showComments(@PathVariable("postingId") Long postingId) {
        return commentService.getComments(postingId);
    }

    @PutMapping(value="/comments/{postingId}/{commentId}")
    public void updateComment(@PathVariable("postingId") Long postingId, @PathVariable("commentId") Long commentId) {
        Optional<Comment> updated = commentService.getComment(postingId, commentId);
    }

    @DeleteMapping(value="/comments/{postingId}/{commentId}")
    public void deleteComment(@PathVariable("postingId") Long postingId, @PathVariable("commentId") Long commentId) {
        commentService.deleteComment(postingId, commentId);
    }

}
