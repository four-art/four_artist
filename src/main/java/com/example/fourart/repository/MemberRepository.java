package com.example.fourart.repository;

import com.example.fourart.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member,Long>{
    Member findByEmail(String email);
    List<Member> findAllByEmail(String email);
}
