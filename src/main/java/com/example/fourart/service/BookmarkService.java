package com.example.fourart.service;

import com.example.fourart.entity.PostingBookmark;
import com.example.fourart.repository.BookmarkRepository;
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

    private final BookmarkRepository bookmarkRepository;

    @Transactional
    public void saveBookmark(PostingBookmark bookmark) {
        bookmarkRepository.save(bookmark);
    }

    public List<PostingBookmark> findBookmarks() {
        return bookmarkRepository.findAll();
    }
    public Optional<PostingBookmark> findBookmarksByMemberId(Long id){return bookmarkRepository.findById(id);}
    public void deleteBookmark(Long id){ bookmarkRepository.deleteById(id);}
}
