package com.project.introduceourtown.repository;

import com.project.introduceourtown.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByUsername(String username);
    Member findByEmail(String email);
    Optional<Member> findById(Long memberId);
}
