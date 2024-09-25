package com.project.introduceourtown.service;

import com.project.introduceourtown.domain.Keyword;
import com.project.introduceourtown.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KeywordService {
    private final KeywordRepository keywordRepository;

    public List<Keyword> findByMemberId(Long memberId) {
        return keywordRepository.findByMemberId(memberId);
    }

    public List<String> findKeywordList(List<Keyword> keywordList) {
        return keywordList.stream()
                .map(Keyword::getKeyword)  // 각 Keyword 객체의 'keyword' 속성 추출
                .collect(Collectors.toList());  // List<String>으로 수집
    }
}
