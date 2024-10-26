package com.project.introduceourtown.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.introduceourtown.dto.flaskDto.FlaskRequestDto;
import com.project.introduceourtown.dto.flaskDto.FlaskWithImageRequestDto;
import com.project.introduceourtown.service.FlaskService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class FlaskController {

    private final FlaskService flaskService;

    /**
     * Flask로 데이터 전송
     */
    @PostMapping("/find/town")
    @Operation(summary = "동네 추천 (Text) api")
    public ResponseEntity<?> sendToAIserverWithText(@RequestBody FlaskRequestDto dto) throws JsonProcessingException {
        // Long memberId = userDetails.getMemberId();
        return ResponseEntity.status(HttpStatus.OK).body(flaskService.sendToFlask(dto));
    }

    @PostMapping("/find/image")
    @Operation(summary = "이미지를 통한 추천(Image and Text) api")
    public ResponseEntity<?> sendToAIserverWithImage(@RequestPart("location") String location,
                                                     @RequestPart("imageFile") MultipartFile imageFile) {
        // Long memberId = userDetails.getMemberId();
        return ResponseEntity.status(HttpStatus.OK).body(flaskService.sendToFlaskWithImage(imageFile, location));
    }
}