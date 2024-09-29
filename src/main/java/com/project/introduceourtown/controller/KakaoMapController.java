package com.project.introduceourtown.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.introduceourtown.dto.flaskDto.FlaskRequestDto;
import com.project.introduceourtown.dto.kakaomapDto.KakaoMapRequestDto;
import com.project.introduceourtown.dto.kakaomapDto.KakaoMapResponseDto;
import com.project.introduceourtown.service.FlaskService;
import com.project.introduceourtown.service.KakaoMapService;
import com.project.introduceourtown.service.KeywordService;
import com.project.introduceourtown.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class KakaoMapController {

    private final KakaoMapService kakaoMapService;

    @PostMapping("/find/keyword/")
    @Operation(summary = "키워드, 반경을 바탕으로 위치 조회")
    public ResponseEntity<?> kakaoPlace(

                                            @RequestBody KakaoMapRequestDto request) {

        List<KakaoMapResponseDto> response = kakaoMapService.getPlaceByKeywords(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



}
