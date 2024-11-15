package com.project.introduceourtown.controller;

import com.project.introduceourtown.domain.Keyword;
import com.project.introduceourtown.dto.OAuth2Reponse.CustomOAuth2User;
import com.project.introduceourtown.dto.keywordDto.KeywordListResponseDto;
import com.project.introduceourtown.service.KeywordService;
import com.project.introduceourtown.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final KeywordService keywordService;

    @GetMapping("/member/keywordList/{memberId}")
    @Operation(summary = "사용자의 KeywordList를 조회하는 api")
    public ResponseEntity<?> findKeywordList(
            @PathVariable(value = "memberId")Long memberId//@AuthenticationPrincipal CustomOAuth2User customOAuth2User
            ){
       // Long memberId = customOAuth2User.getMemberId();
        List<Keyword> keywordList = keywordService.findByMemberId(memberId);
        List<String> keywords = keywordService.findKeywordList(keywordList);
        return ResponseEntity.status(HttpStatus.OK).body(new KeywordListResponseDto(keywords));
    }
}
