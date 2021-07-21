package com.example.fourart.repository;

import com.example.fourart.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchRepository extends JpaRepository<Posting, Long> {

}
