package com.example.fourart.controller;

import com.example.fourart.entity.MemberBookmark;
import com.example.fourart.entity.PostingBookmark;
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
    /**
     * TODO:
     * 멤버 북마크 추가, 삭제 구현.
     * 북마크한 게시글 보여주기.
     * 북마크한 아티스트 보여주기.
     */
    private final BookmarkService bookmarkService;
    @PostMapping("/posting/new")
    public void addPostingBookmark(@RequestBody Long postingId,@RequestBody Long memberId){
        PostingBookmark bookmark = new PostingBookmark();
        bookmark.setPostingId(postingId);
        bookmark.setMemberId(memberId);
        bookmarkService.savePostingBookmark(bookmark);
    }
    @PostMapping("/member/new")
    public void addMemberBookmark(@RequestBody Long memberId,@RequestBody Long addMemberId){
        MemberBookmark bookmark = new MemberBookmark();
        bookmark.setMarkedMemberId(memberId);
        bookmark.setMemberId(addMemberId);
        bookmarkService.saveMemberBookmark(bookmark);
    }
    @PostMapping("/posting/delete")
    public void deletePostingBookmark(@RequestBody Long bookmarkId){
        bookmarkService.deletePostingBookmark(bookmarkId);
    }
    @PostMapping("/member/delete")
    public void deleteMemberBookmark(@RequestBody Long bookmarkId){
        bookmarkService.deleteMemberBookmark(bookmarkId);
    }
}
