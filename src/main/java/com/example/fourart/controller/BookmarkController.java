package com.example.fourart.controller;

import com.example.fourart.entity.Bookmark;
import com.example.fourart.service.BookmarkService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@Api(tags={"북마크 API"})
@RequestMapping("bookmark")
public class BookmarkController {
    private final BookmarkService bookmarkService;
    @PostMapping("/new")
    public void addBookmark(@RequestBody Long postingId,@RequestBody Long memberId){
        Bookmark bookmark = new Bookmark();
        bookmark.setPostingId(postingId);
        bookmark.setMemberId(memberId);
        bookmarkService.saveBookmark(bookmark);
    }
    @PostMapping("/delete")
    public void deleteBookmark(@RequestBody Long bookmarkId){
        bookmarkService.deleteBookmark(bookmarkId);
    }
}
