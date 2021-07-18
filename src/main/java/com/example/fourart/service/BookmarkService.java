package com.example.fourart.service;

import com.example.fourart.entity.Bookmark;
import com.example.fourart.entity.Posting;
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
    public void saveBookmark(Bookmark bookmark) {
        bookmarkRepository.save(bookmark);
    }

    public List<Bookmark> findBookmarks() {
        return bookmarkRepository.findAll();
    }
    public Optional<Bookmark> findBookmarksByMemberId(Long id){return bookmarkRepository.findById(id);}
    public void deleteBookmark(Long id){ bookmarkRepository.deleteById(id);}
}
