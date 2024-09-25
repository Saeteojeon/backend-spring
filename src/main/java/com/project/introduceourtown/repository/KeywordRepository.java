package com.project.introduceourtown.repository;

import com.project.introduceourtown.domain.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
    List<Keyword> findByMemberId(Long memberId);
}
