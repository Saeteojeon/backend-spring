package com.project.introduceourtown.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.introduceourtown.dto.flaskDto.FlaskRequestDto;
import com.project.introduceourtown.service.FlaskService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class FlaskController {

    private final FlaskService flaskService;

    /**
     * Flask로 데이터 전송
     */
    @GetMapping("/find/town")
    @Operation(summary = "동네 추천 api")
    public ResponseEntity<?> sendToAIserver(//@AuthenticationPrincipal CustomOAuth2User userDetails,
                                            @PathVariable(value = "memberId")Long memberId,
                                            @RequestBody FlaskRequestDto dto) throws JsonProcessingException {
        // Long memberId = userDetails.getMemberId();
        return ResponseEntity.status(HttpStatus.OK).body(flaskService.sendToFlask(dto));
    }
}