package com.project.introduceourtown.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.introduceourtown.dto.flaskDto.FlaskRequestDto;
import com.project.introduceourtown.service.FlaskService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FlaskController {

    private final FlaskService flaskService;

    /**
     * Flask로 데이터 전송
     */
    @PostMapping("/flask")
    @Operation(summary = "프론트에서 받은 질문을 AI서버로 전달 후 응답 받기")
    public ResponseEntity<?> sendToFlask(@RequestBody FlaskRequestDto dto) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK).body(flaskService.sendToFlask(dto));
    }
}