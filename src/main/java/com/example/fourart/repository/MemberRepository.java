package com.example.fourart.repository;

import com.example.fourart.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long>{
    List<Member> findAllByEmail(@Param("email")String email);
    Member findByEmail(@Param("email")String email);
}
