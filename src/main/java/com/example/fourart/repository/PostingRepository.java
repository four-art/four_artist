package com.example.fourart.repository;

import com.example.fourart.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PostingRepository{
    void save(Posting ps);
    void delete();
    Posting findOne();
    List<Posting> findAll();
}
