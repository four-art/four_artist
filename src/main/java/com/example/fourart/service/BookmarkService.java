package com.example.fourart.service;

import com.example.fourart.entity.MemberBookmark;
import com.example.fourart.entity.PostingBookmark;
import com.example.fourart.repository.MemberBookmarkRepository;
import com.example.fourart.repository.PostingBookmarkRepository;
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
public class BookmarkService {

    private final PostingBookmarkRepository postingBookmarkRepository;
    private final MemberBookmarkRepository memberBookmarkRepository;
    @Transactional
    public void savePostingBookmark(PostingBookmark bookmark) {
        postingBookmarkRepository.save(bookmark);
    }
    @Transactional
    public void saveMemberBookmark(MemberBookmark bookmark){ memberBookmarkRepository.save(bookmark);}
    public List<PostingBookmark> findBookmarks() {
        return postingBookmarkRepository.findAll();
    }
    public Optional<PostingBookmark> findPostingBookmarksByMemberId(Long id){return postingBookmarkRepository.findById(id);}
    public void deletePostingBookmark(Long id){ postingBookmarkRepository.deleteById(id);}
    public Optional<MemberBookmark> findMemberBookmarksByMemberId(Long id){return memberBookmarkRepository.findById(id);}
    public void deleteMemberBookmark(Long id){ memberBookmarkRepository.deleteById(id);}
}
