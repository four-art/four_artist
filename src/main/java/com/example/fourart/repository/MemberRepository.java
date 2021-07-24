package com.example.fourart.repository;

import com.example.fourart.entity.HashTag;
import com.example.fourart.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long>{
    List<Member> findAllByEmail(@Param("email")String email);
    Member findByEmail(@Param("email")String email);
}
